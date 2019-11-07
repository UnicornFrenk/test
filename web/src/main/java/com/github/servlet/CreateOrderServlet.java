package com.github.servlet;

import com.github.impl.DefaultItemService;
import com.github.model.Item;
import com.github.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/createOrder")
public class CreateOrderServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ItemsServlet.class);

    ItemService itemService = DefaultItemService.getInstance();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Item> items = itemService.getAll();
        request.setAttribute("items", items);

        response.sendRedirect(request.getContextPath() + "/createOrder");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        Integer price = Integer.valueOf(request.getParameter("price"));

        Item item = DefaultItemService.getInstance().createItem(new Item(name, description, quantity, price));

        if (item != null) {
            request.getSession().setAttribute("item", item);
            request.getSession().setAttribute("name", name);
            request.getSession().setAttribute("description", description);
            request.getSession().setAttribute("quantity", quantity);
            request.getSession().setAttribute("price", price);

            try {
                response.sendRedirect(request.getContextPath() + "/itemlistadmin");
            } catch (IOException e) {
                log.error("unknown error", e);
                throw new RuntimeException(e);
            }
    }
}
}
