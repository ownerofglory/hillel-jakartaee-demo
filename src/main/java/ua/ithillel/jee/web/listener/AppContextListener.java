package ua.ithillel.jee.web.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import ua.ithillel.jee.service.TaskInMemoryService;
import ua.ithillel.jee.service.TaskService;
import ua.ithillel.jee.web.TaskAppServlet;

public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final String initParameter = sce.getServletContext().getInitParameter("jdbc-url");

        TaskService taskService = new TaskInMemoryService();
        final TaskAppServlet taskAppServlet = new TaskAppServlet(taskService);

        sce.getServletContext()
                .addServlet("TaskServlet", taskAppServlet)
                .addMapping("/task");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
