package moneytransferapp.retries.workflows;

import java.time.Duration;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;
import moneytransferapp.Shared;
import moneytransferapp.retries.activities.ActivityA;
import moneytransferapp.retries.activities.ActivityB;

public class MyDependency {
    private final ActivityOptions activityAOptions;
    private final ActivityOptions activityBOptions;
    private final MySubDependency subDependency;

    private final RetryOptions retryoptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(1))
            .setMaximumInterval(Duration.ofSeconds(100))
            .setBackoffCoefficient(2)
            .setMaximumAttempts(500)
            .build();

    public MyDependency(MySubDependency subDependency) {
        this.subDependency = subDependency;
        this.activityAOptions = ActivityOptions.newBuilder()
                .setScheduleToCloseTimeout(Duration.ofSeconds(60))
                .setTaskQueue(Shared.ACTIVITY_A_TASK_QUEUE)
                .setRetryOptions(retryoptions)
                .build();
        this.activityBOptions = ActivityOptions.newBuilder()
                .setScheduleToCloseTimeout(Duration.ofSeconds(60))
                .setTaskQueue(Shared.ACTIVITY_B_TASK_QUEUE)
                .setRetryOptions(retryoptions)
                .build();
    }


    public String doWork(String input) {
        ActivityA activityA = Workflow.newActivityStub(ActivityA.class, activityAOptions);
        ActivityB activityB = Workflow.newActivityStub(ActivityB.class, activityBOptions);
        String apiResult = activityA.doInsert(input);
        String doWorkResult = subDependency.doSubWork(apiResult);
        activityA.doRead("readIt");
        return activityB.doB(doWorkResult);
    }
}
