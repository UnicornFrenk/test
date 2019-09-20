package Servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LogoutServlet extends HttpServlet {

    protected void goGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
String userName =request.getParameter("username");
String password = request.getParameter("password");
        Map<String,String> messages = new HashMap<String, String>();

        if(userName == null||userName.isEmpty()){
         messages.put("username","Please enter username");
        }

        if (password==null||password.isEmpty()){
            messages.put("password","Please input password");
        }

//        if (messages.isEmpty()){
//            User user = userService.find (userName,password);
//
//            if(user!=null){
//                request.getSession().setAttribute("user",user);
//                response.sendRedirect(request.getContextPath()+"/home");
//                return;
//            } else {
//                messages.put("login","Unknown login, please try again");
//            }
//        }

        request.setAttribute("message", messages);
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }
}
