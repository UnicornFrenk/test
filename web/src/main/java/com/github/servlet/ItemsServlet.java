package com.github.servlet;

import com.github.impl.DefaultItemService;
import com.github.model.Item;
import com.github.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/itemlist")
public class ItemsServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ItemsServlet.class);
    private ItemService itemService = DefaultItemService.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String pageNumber1 = request.getParameter("pageNumber");
        if (pageNumber1 == null) {
            pageNumber1 = "1";
        }

        Integer pageNumber = Integer.valueOf(pageNumber1);

        List<Item> items = itemService.getPage(pageNumber);
        request.setAttribute("items", items);

        Long countOfPage = itemService.countOfPage();
        request.setAttribute("pageCount", countOfPage);

        WebUtils.forword("/itemlist", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String item_name = request.getParameter("item_name");
        itemService.readItem(item_name);
        WebUtils.forword("/itemlist", request, response);
        try {
            response.sendRedirect(request.getContextPath() + "/itemlist");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }


    }


}




