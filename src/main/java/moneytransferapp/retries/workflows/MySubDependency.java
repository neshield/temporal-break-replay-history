package moneytransferapp.retries.workflows;

import java.time.Duration;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;
import moneytransferapp.Shared;
import moneytransferapp.retries.activities.ActivityA;

public class MySubDependency {
    private final ActivityOptions activityAOptions;

    private final RetryOptions retryoptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(1))
            .setMaximumInterval(Duration.ofSeconds(100))
            .setBackoffCoefficient(2)
            .setMaximumAttempts(500)
            .build();
    public MySubDependency() {
        this.activityAOptions = ActivityOptions.newBuilder()
                .setScheduleToCloseTimeout(Duration.ofSeconds(60))
                .setTaskQueue(Shared.ACTIVITY_A_TASK_QUEUE)
                .setRetryOptions(retryoptions)
                .build();
    }

    public String doSubWork(String input) {
        ActivityA activityA = Workflow.newActivityStub(ActivityA.class, activityAOptions);
        activityA.doRead("readIt");
        return input + "workComplete";
    }
}
