package servlet;

import Dao.ItemDao;
import Dao.impl.DefaultItemDao;
import Model.Item;
import com.github.ItemService;
import com.github.impl.DefaultItemServise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/deleteitem")
public class DeleteItemServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DeleteItemServlet.class);
    private ItemService itemService = DefaultItemServise.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        WebUtils.forword("deleteitem", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String itemName = request.getParameter("del");
        itemService.deleteItem(itemName);
        try {
            response.sendRedirect(request.getContextPath() + "/itemlistadmin");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }
}
