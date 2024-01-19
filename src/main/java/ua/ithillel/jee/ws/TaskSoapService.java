package ua.ithillel.jee.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import ua.ithillel.jee.model.Task;
import ua.ithillel.jee.model.TaskList;
import ua.ithillel.jee.service.TaskInMemoryService;
import ua.ithillel.jee.service.TaskService;

import java.util.List;

@WebService(targetNamespace = "http://ws.jee.ithillel.ua")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class TaskSoapService {
    // hard-code dependency
    // TODO: use injection

     private TaskService taskService = new TaskInMemoryService();

    @WebMethod
    public void addTask(@WebParam(name = "task") Task task) {
        taskService.add(task);
    }

    @WebMethod
    public TaskList getAllTasks() {
        final List<Task> tasks = taskService.getTasks();
        final TaskList taskList = new TaskList();
        taskList.setTasks(tasks);

        return taskList;
    }
}
