package com.github.servlet;

import com.github.impl.DefaultItemService;
import com.github.model.Item;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createitem")
public class CreateItemServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(ItemsServlet.class);
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/createitem.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String name = rq.getParameter("item_name");
        rq.setAttribute("item_name", name);
        String description = rq.getParameter("item_description");
        rq.setAttribute("item_description", description);
        Integer quantity = Integer.valueOf(rq.getParameter("item_quantity"));
        rq.setAttribute("item_quantity", quantity);
        Integer price = Integer.valueOf(rq.getParameter("price_for_one"));
        rq.setAttribute("price_for_one", price);

        DefaultItemService.getInstance().createItem(new Item());

        try {
            rs.sendRedirect(rq.getContextPath() + "/itemlistadmin");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }
}
