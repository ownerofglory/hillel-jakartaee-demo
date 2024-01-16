package ua.ithillel.jee.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SampleServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        final String strParam = config.getInitParameter("strParam");

        System.out.println("Servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Incoming request: " +  req.getPathInfo());

        resp.getWriter().println("This is a server message");
        resp.getWriter().flush();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet destroy");
    }
}
