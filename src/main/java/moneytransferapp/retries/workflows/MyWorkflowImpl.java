package moneytransferapp.retries.workflows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.failure.TemporalFailure;
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;
import io.temporal.workflow.Workflow;
import moneytransferapp.Shared;
import moneytransferapp.retries.activities.ActivityA;
import moneytransferapp.retries.activities.ActivityB;

public class MyWorkflowImpl implements MyWorkflow {
//    private final ActivityOptions activityAOptions;
//    private final ActivityOptions activityBOptions;
    private final MyDependency dependency;

    private final RetryOptions retryoptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(1))
            .setMaximumInterval(Duration.ofSeconds(100))
            .setBackoffCoefficient(2)
            .setMaximumAttempts(500)
            .build();

    public MyWorkflowImpl(MyDependency dependency) {
        this.dependency = dependency;
//        this.activityAOptions = ActivityOptions.newBuilder()
//                .setScheduleToCloseTimeout(Duration.ofSeconds(60))
//                .setTaskQueue(Shared.ACTIVITY_A_TASK_QUEUE)
//                .setRetryOptions(retryoptions)
//                .build();
//        this.activityBOptions = ActivityOptions.newBuilder()
//                .setScheduleToCloseTimeout(Duration.ofSeconds(60))
//                .setTaskQueue(Shared.ACTIVITY_B_TASK_QUEUE)
//                .setRetryOptions(retryoptions)
//                .build();
    }

    public int doProcess(String input1, String input2, String input3, String input4) {
        List<Promise<Void>> processingPromises = new ArrayList<>();

        for (MyObject obj : List.of(new MyObject(input1), new MyObject(input2), new MyObject(input3), new MyObject(input4))) {
            // Using Temporal's Async makes replay occur in a consistent order.
            Promise<Void> promise = Async.procedure(this::processMyObject, obj);
            processingPromises.add(promise);
        }

        // Get each promise result one by one.
        for (Promise<Void> promise : processingPromises) {
            try {
                promise.get();
            } catch (TemporalFailure temporalFailure) {
                System.out.println("processMyObject threw a TemporalFailure exception. Swallowing the exception to allow"
                        + " Workflow to continue processing other MyObject: " + temporalFailure);
            } catch (Exception exception) {
                System.out.println("processMyObject threw a nonTemporalFailure exception. Propagating the exception to allow"
                        + " MyWorkflow to retry processing this MyObject by replaying the workflow." + exception);
                throw exception;
            }
        }
        return processingPromises.size();
    }

    private void processMyObject(MyObject obj) {
        dependency.doWork(obj.getValue());
    }
}
