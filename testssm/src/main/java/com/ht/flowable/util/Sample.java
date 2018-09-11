package com.ht.flowable.util;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hetao on 2018/9/5
 */
public class Sample {


    public static void main(String[] args) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

//        Map<String, Object> variables = new HashMap<String, Object>();
//        variables.put("employee", "jack");
//        variables.put("nrOfHolidays", 3);
//        variables.put("description", "回家看看");
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);


        // 获取待办任务列表
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
        System.out.println("你有 " + tasks.size() + " 个待办任务:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ") " + tasks.get(i).getName());
        }

        Task task = tasks.get(0);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        System.out.println(processVariables.get("employee") + " wants " +
                processVariables.get("nrOfHolidays") + " of holidays. Do you approve this?");

        Map<String, Object> variables1 = new HashMap<String, Object>();
        variables1.put("approved", true);
        variables1.put("ewai", "hetao");
        taskService.complete(task.getId(), variables1);

        System.out.println("执行完后  你有 " + tasks.size() + " 个待办任务:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ") " + tasks.get(i).getName());
        }

    }

}
