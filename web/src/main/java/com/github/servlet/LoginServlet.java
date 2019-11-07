package com.github.servlet;


import com.github.PersonService;
import com.github.hib.dao.impl.DefaultPersonDao;
import com.github.hib.entity.PersonEntity;
import com.github.impl.DefaultPersonService;
import com.github.model.Person;
import com.github.SecurityService;
import com.github.impl.DefaultSecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
            Person user = new Person(login, password);
            DefaultPersonService.getInstance().getByLogin(user.getLogin());


            if (user!= null) {
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("login", login);
                request.getSession().setAttribute("password", password);
                response.addCookie(new Cookie("myUserCookie", user.getLogin()));
                WebUtils.forword("/authUser", request, response);

                if (request.getSession().getAttribute("user") != null) {
                    request.getRequestDispatcher("/authUser.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
                return;
            }

}}
