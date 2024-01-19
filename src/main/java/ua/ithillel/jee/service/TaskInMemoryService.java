package ua.ithillel.jee.service;

import ua.ithillel.jee.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskInMemoryService implements TaskService {
    private List<Task> taskStorage = new ArrayList<>();

    public TaskInMemoryService() {
    }

    @Override
    public List<Task> getTasks() {
        return taskStorage;
    }

    @Override
    public void add(Task task) {
        taskStorage.add(task);
    }

    @Override
    public Task updateTask(Task task) throws Exception {
        final int index = taskStorage.indexOf(task);
        if (index < 0) {
            throw new Exception("Task does not exist");
        }

        final Task exisitingTask = taskStorage.get(index);
        exisitingTask.setStatus(!exisitingTask.isStatus());

        return exisitingTask;
    }
}
