package com.github.servlet;

import com.github.PersonService;
import com.github.impl.DefaultPersonService;
import com.github.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DeleteUserServlet.class);
    private PersonService personService = DefaultPersonService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        List<Person> users = personService.getAll();
        request.setAttribute("items", users);
        WebUtils.forword("users", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("deleteUser");
        personService.deletePerson(name);
        try {
            response.sendRedirect(request.getContextPath() + "/users");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }
}
