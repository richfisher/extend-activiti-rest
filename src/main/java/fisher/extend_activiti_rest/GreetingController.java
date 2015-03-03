package fisher.extend_activiti_rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import static java.lang.System.*;
import java.util.*;

@RestController
public class GreetingController {
    @Autowired
    private ApplicationContext appContext;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        ProcessEngine processEngine = appContext.getBean(ProcessEngine.class);
        TaskService taskService = processEngine.getTaskService();
        List<Task> availableTaskList = taskService.createTaskQuery().list();
        System.out.println(availableTaskList.size());

        return "Hello World!";
    }
}
