package moneytransferapp.retries;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.client.WorkflowStub;
import io.temporal.testing.TestWorkflowEnvironment;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkflowImplementationOptions;
import moneytransferapp.Shared;
import moneytransferapp.retries.activities.ActivityAImpl;
import moneytransferapp.retries.activities.ActivityB;
import moneytransferapp.retries.activities.ActivityBImpl;
import moneytransferapp.retries.workflows.ActivityADependency;
import moneytransferapp.retries.workflows.MyDependency;
import moneytransferapp.retries.workflows.MySubDependency;
import moneytransferapp.retries.workflows.MyWorkflow;
import moneytransferapp.retries.workflows.MyWorkflowImpl;

public class MyWorkflowImplRetriesTest {
    private TestWorkflowEnvironment testEnv;
    private Worker worker;
    private WorkflowClient workflowClient;
    @Mock private MySubDependency subDependency;
    @Mock private ActivityADependency activityADependency;
    @Mock private ActivityB activityB;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        testEnv = TestWorkflowEnvironment.newInstance();
        worker = testEnv.newWorker(Shared.MY_WORKFLOW_TASK_QUEUE);
        worker.addWorkflowImplementationFactory(WorkflowImplementationOptions.newBuilder().build(), MyWorkflow.class,
                () -> new MyWorkflowImpl(new MyDependency(subDependency)));

        when(activityADependency.insertIntoTable()).thenReturn(true);
        when(activityADependency.readFromTable()).thenReturn("valueFromTable");

        testEnv.newWorker(Shared.ACTIVITY_A_TASK_QUEUE).registerActivitiesImplementations(new ActivityAImpl(activityADependency));
//        testEnv.newWorker(Shared.ACTIVITY_B_TASK_QUEUE).registerActivitiesImplementations(new ActivityBImpl());
        testEnv.newWorker(Shared.ACTIVITY_B_TASK_QUEUE).registerActivitiesImplementations(activityB);

        workflowClient = testEnv.getWorkflowClient();
    }

    @AfterEach
    public void tearDown() {
        testEnv.close();
    }

    @Test
    public void testMyWorkflow() {
        testEnv.start();
        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(Shared.MY_WORKFLOW_TASK_QUEUE)
                .build();
        MyWorkflow workflow = workflowClient.newWorkflowStub(MyWorkflow.class, options);
        WorkflowClient.start(workflow::doProcess, "val1", "val2", "val3", "val4");
        WorkflowStub stub = WorkflowStub.fromTyped(workflow);
        try {
            int result = stub.getResult(Integer.class);
            assertEquals(4, result);
            verify(activityB, times(4)).doB(any());
        } catch (Exception e) {
            // rdar://82258481 (SWT ACH investigate testNPEOutsideActivityCausesARetry failure in build)
            // Caused by: java.lang.IllegalStateException: COMMAND_TYPE_SCHEDULE_ACTIVITY_TASK doesn't match
            // EVENT_TYPE_ACTIVITY_TASK_SCHEDULED with EventId=29
            // https://community.temporal.io/t/workflows-struck-not-broke-deterministic-nature-of-workflow-to-best-of-my-knowledge/2467
            fail("An exception was thrown during getResult.", e);
        }
    }
}
