package com.gourianova.acoustic.action.admin.item;

import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.ConstructService;
import com.gourianova.acoustic.service.ItemService;
import com.gourianova.acoustic.service.MaterialService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;


public class AddItemAction implements Action {
    private final static String TITLE = "title";
    private final static String MODEL = "model";
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

    private final static String MESSAGE = "message";
    private final static String WRONG_RANGE_DATA = "wrongRangeData";
    private final static String REFERRER = "referrer";
    private final static String ITEM = "item";
    private final static String TYPE_LIST = "constructsList";
    private final static String UNIT_LIST = "materialsList";

    private final static String ADD_PAGE = "/includeAdmin/item_add.jsp";

    private final static String ADMIN_PAGE = "/controller?action=show_admin_page";
    //="/controller?action=show_add_item_page";
    private final ItemService itemService = new ItemService();
    private final ConstructService constructService = new ConstructService();
    private final MaterialService materialService = new MaterialService();


    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        Router router = new Router();
        Item item = new Item();
        HttpSession session = request.getSession();
        item.setName(request.getParameter(TITLE));
        item.setModel(request.getParameter(MODEL));
        item.setThickness(new BigDecimal(request.getParameter(THICKNESS)));
        item.setDensity(new BigDecimal(request.getParameter(DENSITY)));
        item.setSi63(new Integer(request.getParameter(SI63)));
        item.setSi125(new Integer(request.getParameter(SI125)));
        item.setSi250(new Integer(request.getParameter(SI250)));
        item.setSi500(new Integer(request.getParameter(SI500)));
        item.setSi1000(new Integer(request.getParameter(SI1000)));
        item.setSi2000(new Integer(request.getParameter(SI2000)));
        item.setSi4000(new Integer(request.getParameter(SI4000)));
        item.setSi8000(new Integer(request.getParameter(SI8000)));

        try {
            if (itemService.createItem(item)) {
                session.setAttribute(ITEM, item);
                 router.setPagePath(ADD_PAGE);
                router.setRoute(Router.RouteType.REDIRECT);
            }


        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
