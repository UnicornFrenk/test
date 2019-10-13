package servlet;

import Model.Item;
import com.github.ItemService;
import com.github.impl.DefaultItemServise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {
    ItemService itemService = DefaultItemServise.getInstance();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Item> items = itemService.getAll();
        request.setAttribute("items", items);
        WebUtils.forword("createOrder", request, response);
        request.getRequestDispatcher("/createorder.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        request.getRequestDispatcher("/createorder.jsp").forward(request, response);
    }
}
