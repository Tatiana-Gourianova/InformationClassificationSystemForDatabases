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
import java.util.ArrayList;


public class ShowAllUserItemsAction implements Action {
    private final static String ITEMS_LIST = "itemsList";
    private final static String MESSAGE = "message";
    private final ItemService itemService = new ItemService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        ArrayList<Item> itemsList;
        try {
            itemsList = itemService.findAll();
            request.setAttribute(ITEMS_LIST, itemsList);
            router.setPagePath(PageConstant.MAIN_PAGE);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
