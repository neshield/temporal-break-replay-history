package moneytransferapp.retries.workflows;

public class ActivityADependency {
    public boolean insertIntoTable() {
        return true;
    }

    public String readFromTable() {
        return "valueFromTable";
    }
}
