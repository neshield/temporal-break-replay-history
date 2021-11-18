package moneytransferapp.retries.workflows;

import java.util.List;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface MyWorkflow {
    @WorkflowMethod
    int doProcess(String input1, String input2, String input3, String input4);
}
