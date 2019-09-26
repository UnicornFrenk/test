package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/*")
public class Servlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String path ="/index.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);

        requestDispatcher.forward(request,response);
        //response.sendRedirect("/startpage.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)  {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {

    }

}