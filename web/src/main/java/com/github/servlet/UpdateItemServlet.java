package com.github.servlet;

import com.github.ItemService;
import com.github.impl.DefaultItemService;
import com.github.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/updateitem")
public class UpdateItemServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(UsersServlet.class);
    private ItemService itemService = DefaultItemService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Item item = itemService.readItem(id);
        request.setAttribute("item", item);
        WebUtils.forword("updateitem", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        Integer id = Integer.valueOf(request.getParameter("updateId"));
        Integer price = Integer.parseInt(request.getParameter("price"));
        itemService.updateItem(price, id);
        log.info("item updated:{} at {}", id, LocalDateTime.now());
        try {
            response.sendRedirect(request.getContextPath() + "/itemlistadmin");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }
}
