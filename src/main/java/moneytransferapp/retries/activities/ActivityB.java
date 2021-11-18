package moneytransferapp.retries.activities;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface ActivityB {
    String doB(String input);
}
