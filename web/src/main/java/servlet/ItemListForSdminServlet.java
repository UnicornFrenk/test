package servlet;

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

@WebServlet("/itemlistadmin")
public class ItemListForSdminServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(ItemsServlet.class);
    private ItemService itemService = DefaultItemServise.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        List<Item> items = itemService.getAll();
        request.setAttribute("items", items);
        WebUtils.forword("itemlistadmin", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String item_name = request.getParameter("item_name");
        itemService.readItem(item_name);
        try {
            response.sendRedirect(request.getContextPath() + "/itemlistadmin");
        } catch (IOException e) {
            log.error("unknown error", e);
            throw new RuntimeException(e);
        }
    }

}
