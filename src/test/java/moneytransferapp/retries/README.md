In intelliJ, select run all the test in the "retries" directory. It should fail around 5% of the time.
Sample error logs:


> Task :compileJava UP-TO-DATE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE
> Task :compileTestJava UP-TO-DATE
> Task :processTestResources NO-SOURCE
> Task :testClasses UP-TO-DATE
> Task :test
18:03:00.335 [Test worker] INFO  i.t.s.WorkflowServiceStubsImpl - Created GRPC client for channel: ManagedChannelOrphanWrapper{delegate=ManagedChannelImpl{logId=1, target=directaddress:///a17db08b-4087-4fa4-9a9b-a3f616a2bfef}}
18:03:00.351 [Test worker] INFO  i.t.s.WorkflowServiceStubsImpl - Created GRPC client for channel: ManagedChannelOrphanWrapper{delegate=ManagedChannelImpl{logId=5, target=directaddress:///db35c48d-eaf7-44d5-bee5-5ea27a4a245a}}
18:03:00.407 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=2, pollThreadNamePrefix='Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default"'}, identity=76913@Nathans-MBP-2.gha.chartermi.net}
18:03:00.409 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=5, pollThreadNamePrefix='Host Local Workflow Poller'}, identity=a0eeb8b9-009f-42d2-8ca0-3685fb5c464f}
18:03:00.750 [Test worker] INFO  io.temporal.worker.WorkerFactory - shutdownNow
18:03:00.750 [Test worker] INFO  io.temporal.internal.worker.Poller - shutdownNow poller=Host Local Workflow Poller
18:03:00.752 [Host Local Workflow Poller: 2] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.752 [Host Local Workflow Poller: 1] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.752 [Host Local Workflow Poller: 4] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.752 [Host Local Workflow Poller: 3] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.752 [Host Local Workflow Poller: 5] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.753 [Test worker] INFO  io.temporal.internal.worker.Poller - shutdownNow poller=Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default"
18:03:00.753 [Test worker] INFO  io.temporal.worker.WorkerFactory - awaitTermination begin
18:03:00.754 [Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 2] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.754 [Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 1] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.754 [Test worker] INFO  io.temporal.worker.WorkerFactory - awaitTermination done
18:03:00.754 [Test worker] INFO  i.t.i.t.TestWorkflowService - Shutting down GRPC server
18:03:00.756 [Test worker] INFO  i.t.s.WorkflowServiceStubsImpl - shutdownNow
18:03:00.780 [Test worker] INFO  i.t.s.WorkflowServiceStubsImpl - Created GRPC client for channel: ManagedChannelOrphanWrapper{delegate=ManagedChannelImpl{logId=9, target=directaddress:///3838254f-a709-445b-9e46-4bd88b3f5794}}
18:03:00.783 [Test worker] INFO  i.t.s.WorkflowServiceStubsImpl - Created GRPC client for channel: ManagedChannelOrphanWrapper{delegate=ManagedChannelImpl{logId=13, target=directaddress:///248528a2-ea84-47c1-9e46-f26b7f917f0d}}
18:03:00.797 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=5, pollThreadNamePrefix='Activity Poller taskQueue="ACTIVITY_A_TASK_QUEUE", namespace="default"'}, identity=76913@Nathans-MBP-2.gha.chartermi.net}
18:03:00.799 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=5, pollThreadNamePrefix='Activity Poller taskQueue="ACTIVITY_B_TASK_QUEUE", namespace="default"'}, identity=76913@Nathans-MBP-2.gha.chartermi.net}
18:03:00.800 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=2, pollThreadNamePrefix='Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default"'}, identity=76913@Nathans-MBP-2.gha.chartermi.net}
18:03:00.802 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=5, pollThreadNamePrefix='Host Local Workflow Poller'}, identity=69cd6ee2-13a6-4c3a-b548-c49576a12efe}
18:03:00.910 [Test worker] INFO  io.temporal.worker.WorkerFactory - shutdownNow
18:03:00.910 [Test worker] INFO  io.temporal.internal.worker.Poller - shutdownNow poller=Host Local Workflow Poller
18:03:00.911 [Host Local Workflow Poller: 1] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.911 [Host Local Workflow Poller: 2] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.911 [Host Local Workflow Poller: 5] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.911 [Host Local Workflow Poller: 3] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.911 [Host Local Workflow Poller: 4] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.912 [Test worker] INFO  io.temporal.internal.worker.Poller - shutdownNow poller=Activity Poller taskQueue="ACTIVITY_A_TASK_QUEUE", namespace="default"
18:03:00.912 [Test worker] INFO  io.temporal.internal.worker.Poller - shutdownNow poller=Activity Poller taskQueue="ACTIVITY_B_TASK_QUEUE", namespace="default"
18:03:00.912 [Test worker] INFO  io.temporal.internal.worker.Poller - shutdownNow poller=Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default"
18:03:00.912 [Activity Poller taskQueue="ACTIVITY_A_TASK_QUEUE", namespace="default": 2] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.912 [Test worker] INFO  io.temporal.worker.WorkerFactory - awaitTermination begin
18:03:00.913 [Activity Poller taskQueue="ACTIVITY_A_TASK_QUEUE", namespace="default": 5] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.913 [Activity Poller taskQueue="ACTIVITY_A_TASK_QUEUE", namespace="default": 4] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.913 [Activity Poller taskQueue="ACTIVITY_B_TASK_QUEUE", namespace="default": 2] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.913 [Activity Poller taskQueue="ACTIVITY_B_TASK_QUEUE", namespace="default": 5] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.914 [Activity Poller taskQueue="ACTIVITY_B_TASK_QUEUE", namespace="default": 4] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.913 [Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 2] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.914 [Activity Poller taskQueue="ACTIVITY_B_TASK_QUEUE", namespace="default": 1] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.913 [Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 1] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.915 [Activity Poller taskQueue="ACTIVITY_B_TASK_QUEUE", namespace="default": 3] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.914 [Activity Poller taskQueue="ACTIVITY_A_TASK_QUEUE", namespace="default": 1] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.914 [Activity Poller taskQueue="ACTIVITY_A_TASK_QUEUE", namespace="default": 3] INFO  io.temporal.internal.worker.Poller - poll loop is terminated
18:03:00.916 [Test worker] INFO  io.temporal.worker.WorkerFactory - awaitTermination done
18:03:00.916 [Test worker] INFO  i.t.i.t.TestWorkflowService - Shutting down GRPC server
18:03:00.916 [Test worker] INFO  i.t.s.WorkflowServiceStubsImpl - shutdownNow
18:03:00.922 [Test worker] INFO  i.t.s.WorkflowServiceStubsImpl - Created GRPC client for channel: ManagedChannelOrphanWrapper{delegate=ManagedChannelImpl{logId=17, target=directaddress:///a1033bec-e760-41bd-845e-3e529d4d8886}}
18:03:00.924 [Test worker] INFO  i.t.s.WorkflowServiceStubsImpl - Created GRPC client for channel: ManagedChannelOrphanWrapper{delegate=ManagedChannelImpl{logId=21, target=directaddress:///f21b1dac-f3ed-42aa-9f5d-af8c69081d64}}
18:03:00.928 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=5, pollThreadNamePrefix='Activity Poller taskQueue="ACTIVITY_A_TASK_QUEUE", namespace="default"'}, identity=76913@Nathans-MBP-2.gha.chartermi.net}
18:03:00.930 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=5, pollThreadNamePrefix='Activity Poller taskQueue="ACTIVITY_B_TASK_QUEUE", namespace="default"'}, identity=76913@Nathans-MBP-2.gha.chartermi.net}
18:03:00.931 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=2, pollThreadNamePrefix='Workflow Poller taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default"'}, identity=76913@Nathans-MBP-2.gha.chartermi.net}
18:03:00.932 [Test worker] INFO  io.temporal.internal.worker.Poller - start(): Poller{options=PollerOptions{maximumPollRateIntervalMilliseconds=1000, maximumPollRatePerSecond=0.0, pollBackoffCoefficient=2.0, pollBackoffInitialInterval=PT0.1S, pollBackoffMaximumInterval=PT1M, pollThreadCount=5, pollThreadNamePrefix='Host Local Workflow Poller'}, identity=f169c877-187a-4031-9838-7e1d088b16d5}
processMyObject threw a nonTemporalFailure exception. Propagating the exception to allow MyWorkflow to retry processing this MyObject by replaying the workflow.java.lang.NullPointerException
18:03:00.993 [Workflow Executor taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 1] ERROR i.t.internal.worker.PollerOptions - uncaught exception
java.lang.RuntimeException: Failure processing workflow task. WorkflowId=940952c4-bf22-44c2-a392-1231a0988f66, RunId=ff6bc068-1f69-41c4-a52a-69e2168cb494, Attempt=2
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:349)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:79)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: io.temporal.internal.replay.InternalWorkflowTaskException: Failure handling event 44 of 'EVENT_TYPE_WORKFLOW_TASK_STARTED' type. IsReplaying=false, PreviousStartedEventId=44, workflowTaskStartedEventId=44, Currently Processing StartedEventId=44
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:188)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleEvent(ReplayWorkflowRunTaskHandler.java:140)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTaskImpl(ReplayWorkflowRunTaskHandler.java:180)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTask(ReplayWorkflowRunTaskHandler.java:150)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTaskWithEmbeddedQuery(ReplayWorkflowTaskHandler.java:201)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTask(ReplayWorkflowTaskHandler.java:114)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:319)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:73)
	... 3 common frames omitted
Caused by: java.lang.RuntimeException: WorkflowTask: failure executing SCHEDULED->WORKFLOW_TASK_STARTED, transition history is [CREATED->WORKFLOW_TASK_SCHEDULED]
	at io.temporal.internal.statemachines.StateMachine.executeTransition(StateMachine.java:140)
	at io.temporal.internal.statemachines.StateMachine.handleHistoryEvent(StateMachine.java:91)
	at io.temporal.internal.statemachines.EntityStateMachineBase.handleEvent(EntityStateMachineBase.java:63)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEventImpl(WorkflowStateMachines.java:205)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:173)
	... 11 common frames omitted
Caused by: java.lang.NullPointerException: null
	at moneytransferapp.retries.workflows.MyDependency.doWork(MyDependency.java:43)
	at moneytransferapp.retries.workflows.MyWorkflowImpl.processMyObject(MyWorkflowImpl.java:69)
	at io.temporal.internal.sync.AsyncInternal.lambda$procedure$c63a8298$1(AsyncInternal.java:187)
	at io.temporal.internal.sync.AsyncInternal.lambda$procedure$c0faf7bb$1(AsyncInternal.java:174)
	at io.temporal.internal.sync.AsyncInternal.lambda$execute$0(AsyncInternal.java:302)
	at io.temporal.internal.sync.CancellationScopeImpl.run(CancellationScopeImpl.java:101)
	at io.temporal.internal.sync.WorkflowThreadImpl$RunnableWrapper.run(WorkflowThreadImpl.java:110)
	at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:515)
	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
	... 3 common frames omitted
18:03:10.988 [Workflow Executor taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 2] ERROR i.t.internal.worker.PollerOptions - uncaught exception
java.lang.RuntimeException: Failure processing workflow task. WorkflowId=940952c4-bf22-44c2-a392-1231a0988f66, RunId=ff6bc068-1f69-41c4-a52a-69e2168cb494, Attempt=2
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:349)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:79)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: io.temporal.internal.replay.InternalWorkflowTaskException: Failure handling event 31 of 'EVENT_TYPE_ACTIVITY_TASK_SCHEDULED' type. IsReplaying=true, PreviousStartedEventId=29, workflowTaskStartedEventId=47, Currently Processing StartedEventId=29
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:188)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleEvent(ReplayWorkflowRunTaskHandler.java:140)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTaskImpl(ReplayWorkflowRunTaskHandler.java:180)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTask(ReplayWorkflowRunTaskHandler.java:150)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTaskWithEmbeddedQuery(ReplayWorkflowTaskHandler.java:201)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTask(ReplayWorkflowTaskHandler.java:114)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:319)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:73)
	... 3 common frames omitted
Caused by: java.lang.IllegalStateException: COMMAND_TYPE_SCHEDULE_ACTIVITY_TASK doesn't match EVENT_TYPE_ACTIVITY_TASK_SCHEDULED with EventId=31
	at io.temporal.internal.statemachines.WorkflowStateMachines.assertMatch(WorkflowStateMachines.java:795)
	at io.temporal.internal.statemachines.WorkflowStateMachines.validateCommand(WorkflowStateMachines.java:748)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleCommandEvent(WorkflowStateMachines.java:285)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEventImpl(WorkflowStateMachines.java:194)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:173)
	... 11 common frames omitted
18:03:20.992 [Workflow Executor taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 3] ERROR i.t.internal.worker.PollerOptions - uncaught exception
java.lang.RuntimeException: Failure processing workflow task. WorkflowId=940952c4-bf22-44c2-a392-1231a0988f66, RunId=ff6bc068-1f69-41c4-a52a-69e2168cb494, Attempt=3
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:349)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:79)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: io.temporal.internal.replay.InternalWorkflowTaskException: Failure handling event 31 of 'EVENT_TYPE_ACTIVITY_TASK_SCHEDULED' type. IsReplaying=true, PreviousStartedEventId=29, workflowTaskStartedEventId=50, Currently Processing StartedEventId=29
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:188)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleEvent(ReplayWorkflowRunTaskHandler.java:140)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTaskImpl(ReplayWorkflowRunTaskHandler.java:180)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTask(ReplayWorkflowRunTaskHandler.java:150)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTaskWithEmbeddedQuery(ReplayWorkflowTaskHandler.java:201)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTask(ReplayWorkflowTaskHandler.java:114)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:319)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:73)
	... 3 common frames omitted
Caused by: java.lang.IllegalStateException: COMMAND_TYPE_SCHEDULE_ACTIVITY_TASK doesn't match EVENT_TYPE_ACTIVITY_TASK_SCHEDULED with EventId=31
	at io.temporal.internal.statemachines.WorkflowStateMachines.assertMatch(WorkflowStateMachines.java:795)
	at io.temporal.internal.statemachines.WorkflowStateMachines.validateCommand(WorkflowStateMachines.java:748)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleCommandEvent(WorkflowStateMachines.java:285)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEventImpl(WorkflowStateMachines.java:194)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:173)
	... 11 common frames omitted
18:03:30.994 [Workflow Executor taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 4] ERROR i.t.internal.worker.PollerOptions - uncaught exception
java.lang.RuntimeException: Failure processing workflow task. WorkflowId=940952c4-bf22-44c2-a392-1231a0988f66, RunId=ff6bc068-1f69-41c4-a52a-69e2168cb494, Attempt=4
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:349)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:79)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: io.temporal.internal.replay.InternalWorkflowTaskException: Failure handling event 31 of 'EVENT_TYPE_ACTIVITY_TASK_SCHEDULED' type. IsReplaying=true, PreviousStartedEventId=29, workflowTaskStartedEventId=53, Currently Processing StartedEventId=29
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:188)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleEvent(ReplayWorkflowRunTaskHandler.java:140)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTaskImpl(ReplayWorkflowRunTaskHandler.java:180)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTask(ReplayWorkflowRunTaskHandler.java:150)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTaskWithEmbeddedQuery(ReplayWorkflowTaskHandler.java:201)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTask(ReplayWorkflowTaskHandler.java:114)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:319)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:73)
	... 3 common frames omitted
Caused by: java.lang.IllegalStateException: COMMAND_TYPE_SCHEDULE_ACTIVITY_TASK doesn't match EVENT_TYPE_ACTIVITY_TASK_SCHEDULED with EventId=31
	at io.temporal.internal.statemachines.WorkflowStateMachines.assertMatch(WorkflowStateMachines.java:795)
	at io.temporal.internal.statemachines.WorkflowStateMachines.validateCommand(WorkflowStateMachines.java:748)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleCommandEvent(WorkflowStateMachines.java:285)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEventImpl(WorkflowStateMachines.java:194)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:173)
	... 11 common frames omitted
18:03:40.998 [Workflow Executor taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 5] ERROR i.t.internal.worker.PollerOptions - uncaught exception
java.lang.RuntimeException: Failure processing workflow task. WorkflowId=940952c4-bf22-44c2-a392-1231a0988f66, RunId=ff6bc068-1f69-41c4-a52a-69e2168cb494, Attempt=5
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:349)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:79)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: io.temporal.internal.replay.InternalWorkflowTaskException: Failure handling event 31 of 'EVENT_TYPE_ACTIVITY_TASK_SCHEDULED' type. IsReplaying=true, PreviousStartedEventId=29, workflowTaskStartedEventId=56, Currently Processing StartedEventId=29
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:188)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleEvent(ReplayWorkflowRunTaskHandler.java:140)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTaskImpl(ReplayWorkflowRunTaskHandler.java:180)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTask(ReplayWorkflowRunTaskHandler.java:150)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTaskWithEmbeddedQuery(ReplayWorkflowTaskHandler.java:201)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTask(ReplayWorkflowTaskHandler.java:114)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:319)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:73)
	... 3 common frames omitted
Caused by: java.lang.IllegalStateException: COMMAND_TYPE_SCHEDULE_ACTIVITY_TASK doesn't match EVENT_TYPE_ACTIVITY_TASK_SCHEDULED with EventId=31
	at io.temporal.internal.statemachines.WorkflowStateMachines.assertMatch(WorkflowStateMachines.java:795)
	at io.temporal.internal.statemachines.WorkflowStateMachines.validateCommand(WorkflowStateMachines.java:748)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleCommandEvent(WorkflowStateMachines.java:285)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEventImpl(WorkflowStateMachines.java:194)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:173)
	... 11 common frames omitted
18:03:51.002 [Workflow Executor taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 6] ERROR i.t.internal.worker.PollerOptions - uncaught exception
java.lang.RuntimeException: Failure processing workflow task. WorkflowId=940952c4-bf22-44c2-a392-1231a0988f66, RunId=ff6bc068-1f69-41c4-a52a-69e2168cb494, Attempt=6
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:349)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:79)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: io.temporal.internal.replay.InternalWorkflowTaskException: Failure handling event 31 of 'EVENT_TYPE_ACTIVITY_TASK_SCHEDULED' type. IsReplaying=true, PreviousStartedEventId=29, workflowTaskStartedEventId=59, Currently Processing StartedEventId=29
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:188)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleEvent(ReplayWorkflowRunTaskHandler.java:140)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTaskImpl(ReplayWorkflowRunTaskHandler.java:180)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTask(ReplayWorkflowRunTaskHandler.java:150)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTaskWithEmbeddedQuery(ReplayWorkflowTaskHandler.java:201)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTask(ReplayWorkflowTaskHandler.java:114)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:319)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:73)
	... 3 common frames omitted
Caused by: java.lang.IllegalStateException: COMMAND_TYPE_SCHEDULE_ACTIVITY_TASK doesn't match EVENT_TYPE_ACTIVITY_TASK_SCHEDULED with EventId=31
	at io.temporal.internal.statemachines.WorkflowStateMachines.assertMatch(WorkflowStateMachines.java:795)
	at io.temporal.internal.statemachines.WorkflowStateMachines.validateCommand(WorkflowStateMachines.java:748)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleCommandEvent(WorkflowStateMachines.java:285)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEventImpl(WorkflowStateMachines.java:194)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:173)
	... 11 common frames omitted
18:04:01.005 [Workflow Executor taskQueue="MY_WORKFLOW_TASK_QUEUE", namespace="default": 7] ERROR i.t.internal.worker.PollerOptions - uncaught exception
java.lang.RuntimeException: Failure processing workflow task. WorkflowId=940952c4-bf22-44c2-a392-1231a0988f66, RunId=ff6bc068-1f69-41c4-a52a-69e2168cb494, Attempt=7
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:349)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.wrapFailure(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:79)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: io.temporal.internal.replay.InternalWorkflowTaskException: Failure handling event 31 of 'EVENT_TYPE_ACTIVITY_TASK_SCHEDULED' type. IsReplaying=true, PreviousStartedEventId=29, workflowTaskStartedEventId=62, Currently Processing StartedEventId=29
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:188)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleEvent(ReplayWorkflowRunTaskHandler.java:140)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTaskImpl(ReplayWorkflowRunTaskHandler.java:180)
	at io.temporal.internal.replay.ReplayWorkflowRunTaskHandler.handleWorkflowTask(ReplayWorkflowRunTaskHandler.java:150)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTaskWithEmbeddedQuery(ReplayWorkflowTaskHandler.java:201)
	at io.temporal.internal.replay.ReplayWorkflowTaskHandler.handleWorkflowTask(ReplayWorkflowTaskHandler.java:114)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:319)
	at io.temporal.internal.worker.WorkflowWorker$TaskHandlerImpl.handle(WorkflowWorker.java:279)
	at io.temporal.internal.worker.PollTaskExecutor.lambda$process$0(PollTaskExecutor.java:73)
	... 3 common frames omitted
Caused by: java.lang.IllegalStateException: COMMAND_TYPE_SCHEDULE_ACTIVITY_TASK doesn't match EVENT_TYPE_ACTIVITY_TASK_SCHEDULED with EventId=31
	at io.temporal.internal.statemachines.WorkflowStateMachines.assertMatch(WorkflowStateMachines.java:795)
	at io.temporal.internal.statemachines.WorkflowStateMachines.validateCommand(WorkflowStateMachines.java:748)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleCommandEvent(WorkflowStateMachines.java:285)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEventImpl(WorkflowStateMachines.java:194)
	at io.temporal.internal.statemachines.WorkflowStateMachines.handleEvent(WorkflowStateMachines.java:173)
	... 11 common frames omitted
> Task :test FAILED
FAILURE: Build failed with an exception.
* What went wrong:
Execution failed for task ':test'.
> Build cancelled while executing task ':test'
* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.
* Get more help at https://help.gradle.org
BUILD FAILED in 1m 8s
4 actionable tasks: 1 executed, 3 up-to-date

