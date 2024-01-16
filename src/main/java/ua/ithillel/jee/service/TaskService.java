package ua.ithillel.jee.service;

import ua.ithillel.jee.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();
    void add(Task task);
    Task updateTask(Task task) throws Exception;
}
