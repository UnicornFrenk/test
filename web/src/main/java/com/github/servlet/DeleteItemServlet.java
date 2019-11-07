package com.github.servlet;

import com.github.ItemService;
import com.github.impl.DefaultItemService;
import com.github.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteitem")
public class DeleteItemServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DeleteItemServlet.class);
    private ItemService itemService = DefaultItemService.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        Integer id = Integer.parseInt(request.getParameter("del"));
        request.setAttribute("id", id );
        itemService.deleteItem(id);
        try {
            response.sendRedirect(request.getContextPath() + "/itemlistadmin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
