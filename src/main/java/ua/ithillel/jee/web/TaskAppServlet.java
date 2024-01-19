package ua.ithillel.jee.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.ithillel.jee.model.Task;
import ua.ithillel.jee.service.TaskService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class TaskAppServlet extends HttpServlet {
    private final TaskService taskService;

    public TaskAppServlet(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Task> tasks = taskService.getTasks();

        req.setAttribute("tasks", tasks);

        req.getRequestDispatcher("/app.jsp").include(req, resp);
//        req.getRequestDispatcher("/app.jsp").forward(req, resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        final String params = req.getReader().readLine();
        if (params == null) {
            return;
        }

        final String value = params.split("=")[1];

        final Task task = new Task();
        task.setName(value);

        taskService.add(task);

        resp.sendRedirect(req.getContextPath() + "/task");
    }
}
