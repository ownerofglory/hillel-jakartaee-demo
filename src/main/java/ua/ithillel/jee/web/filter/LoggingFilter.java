package ua.ithillel.jee.web.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

public class LoggingFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // req flow from Tomcat to Servlet
        System.out.printf("[%s] [%s] - %s %n", "INFO",
                LocalDateTime.now(),
                "Incoming request " + req.getMethod()+  " " + req.getPathInfo());

        chain.doFilter(req, res);

        // resp flow from Servlet to Tomcat
        System.out.printf("[%s] [%s] - %s %n", "INFO",
                LocalDateTime.now(),
                "Response " + res.getStatus());
    }
}
