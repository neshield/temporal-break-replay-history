package moneytransferapp.retries.activities;

import moneytransferapp.retries.workflows.ActivityADependency;

public class ActivityAImpl implements ActivityA {
    public ActivityAImpl(ActivityADependency dependency) {
        this.dependency = dependency;
    }

    private final ActivityADependency dependency;

    @Override public String doInsert(String val) {
        dependency.insertIntoTable();
        return val + "didA";
    }

    @Override public String doRead(String val) {
        return dependency.readFromTable();
    }
}
