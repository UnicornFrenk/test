package com.github.servlet;


import com.github.hib.dao.impl.DefaultPersonDao;
import com.github.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(RegistrationServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String login = rq.getParameter("login");
        rq.setAttribute("login", login);
        String password = rq.getParameter("password");
        rq.setAttribute("password",password);

        DefaultPersonDao.getInstance().createPerson(new Person(login,password));
        try {
            rs.sendRedirect(rq.getContextPath() + "/login");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }
}
