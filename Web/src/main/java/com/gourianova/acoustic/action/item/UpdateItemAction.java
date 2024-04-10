package com.gourianova.acoustic.action.item;

import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.ItemChange;
import com.gourianova.acoustic.User;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.ItemChangeService;
import com.gourianova.acoustic.service.ItemService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
//import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class UpdateItemAction implements Action {
    private final static String USER = "user";
    private final static String USER_ID = "userID";
    private final static String TITLE = "title";
    private final static String THICKNESS = "thickness";
    private final static String DENSITY = "density";
    private final static String SI63 = "si63";
    private final static String SI125 = "si125";
    private final static String SI250 = "si250";
    private final static String SI500 = "si500";

    private final static String SI1000 = "si1000";
    private final static String SI2000 = "si2000";

    private final static String SI4000 = "si4000";

    private final static String SI8000 = "si8000";
    private final static String ITEM_CHANGED = "itemChanged";
    private final static String MESSAGE = "message";
    private final static String ITEM_ID = "itemId";
    private final ItemService itemService = new ItemService();
    private final ItemChangeService itemChangeService = new ItemChangeService();

    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        User user = (User) request.getSession().getAttribute(USER);
        Item item = new Item();
        HttpSession session = request.getSession();
        ItemChange itemChanged = new ItemChange();
        itemChanged.setItemId(new Integer(request.getParameter(ITEM_ID)));
        itemChanged.setItemId(new Integer(user.getId()));

        if (request.getParameter(ITEM_ID) != null) {
            item.setId(Integer.parseInt(request.getParameter(ITEM_ID)));
        }
        item.setName(request.getParameter(TITLE));
        BigDecimal thickness = new BigDecimal(request.getParameter(THICKNESS));

        item.setThickness(thickness);
        BigDecimal density = new BigDecimal(request.getParameter(DENSITY));
        item.setDensity(density);
        item.setSi63(new Integer(request.getParameter(SI63)));
        item.setSi125(new Integer(request.getParameter(SI125)));
        item.setSi250(new Integer(request.getParameter(SI250)));
        item.setSi500(new Integer(request.getParameter(SI500)));
        item.setSi1000(new Integer(request.getParameter(SI1000)));
        item.setSi2000(new Integer(request.getParameter(SI2000)));
        item.setSi4000(new Integer(request.getParameter(SI4000)));
        item.setSi8000(new Integer(request.getParameter(SI8000)));
        try {
System.out.println("UpdateItemAction");
            if (itemChangeService.createItem(itemChanged)) {
                System.out.println("UpdateItemAction createItem(itemChanged) OK");
                session.setAttribute(ITEM_CHANGED, itemChanged);
            }
          item = itemService.updateItem(item);
            if (item!=null)
            {
                System.out.println("UpdateItemAction createItem(itemChanged) OK" + item);
            }
            router.setPagePath(PageConstant.ADMIN_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);

        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }

        return router;
    }
}
