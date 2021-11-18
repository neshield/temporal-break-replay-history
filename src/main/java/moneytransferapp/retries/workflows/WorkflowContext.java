package moneytransferapp.retries.workflows;

import java.util.List;

public class WorkflowContext {
    public WorkflowContext(List<MyObject> objectList) {
        this.objectList = objectList;
    }

    public List<MyObject> getObjectList() {
        return objectList;
    }

    private final List<MyObject> objectList;
}
