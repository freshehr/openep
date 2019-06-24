package com.marand.thinkmed.medications.task.listener;

import java.util.HashMap;
import java.util.Map;

import com.marand.thinkmed.medications.task.PerfusionSyringeDispenseMedicationTaskDef;
import com.marand.thinkmed.medications.task.TaskListenerUtils;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

/**
 * @author Klavdij Lapajne
 */

@Component
public class PerfusionSyringeDispenseMedicationTaskListener implements TaskListener
{
  @Override
  public void notify(final DelegateTask delegateTask)
  {
    if (delegateTask.getEventName().equals(TaskListener.EVENTNAME_CREATE))
    {
      //delegateTask.setAssignee(); //todo which group gets assigned ?
      final Map<String, Object> variablesMap = new HashMap<>();
      TaskListenerUtils.setPerfusionSyringeTaskDefVariables(
          delegateTask,
          PerfusionSyringeDispenseMedicationTaskDef.INSTANCE.getTaskExecutionId(),
          PerfusionSyringeDispenseMedicationTaskDef.INSTANCE.getTaskTypeEnum(),
          variablesMap);
      delegateTask.setVariablesLocal(variablesMap);
    }
  }
}
