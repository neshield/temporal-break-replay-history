package moneytransferapp.retries.activities;

import java.time.Duration;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import moneytransferapp.Shared;

public class ActivityBImpl implements ActivityB{
    private final ActivityOptions activityBOptions;

    private final RetryOptions retryoptions = RetryOptions.newBuilder()
            .setInitialInterval(Duration.ofSeconds(1))
            .setMaximumInterval(Duration.ofSeconds(100))
            .setBackoffCoefficient(2)
            .setMaximumAttempts(500)
            .build();


    public ActivityBImpl() {
        this.activityBOptions = ActivityOptions.newBuilder()
                .setScheduleToCloseTimeout(Duration.ofSeconds(60))
                .setTaskQueue(Shared.ACTIVITY_B_TASK_QUEUE)
                .setRetryOptions(retryoptions)
                .build();
    }

    @Override public String doB(String input) {
        return input + "didB";
    }
}
