package moneytransferapp.retries.activities;

import io.temporal.activity.ActivityInterface;
import moneytransferapp.retries.workflows.MyObject;

@ActivityInterface
public interface ActivityA {
    String doInsert(String val);
    String doRead(String val);
}
