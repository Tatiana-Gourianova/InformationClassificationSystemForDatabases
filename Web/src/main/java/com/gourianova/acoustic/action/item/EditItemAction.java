package com.gourianova.acoustic.action.item;

import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.ItemService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EditItemAction implements Action {
    private final static String ITEM_ID = "itemId";
    private final static String ITEM = "item";
    private final static String MESSAGE = "message";
    private ItemService itemService = new ItemService();


    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
      /*  Integer id;
        try {
            id = Integer.parseInt(request.getParameter(ITEM_ID));
            System.out.println("id" + id);
            itemService.deleteEntityById(id);*/
        try {

            Item item = itemService.findItemById(Integer.parseInt(request.getParameter(ITEM_ID)));
           System.out.println(item);
            request.getSession().setAttribute(ITEM, item);
            router.setPagePath(PageConstant.ITEM_ADD);
            router.setRoute(Router.RouteType.REDIRECT);

        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
