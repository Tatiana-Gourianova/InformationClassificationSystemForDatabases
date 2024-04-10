package com.gourianova.acoustic.action.item;

import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.User;
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


public class ShowAllItemsByPageAction implements Action {

    private final static int PAGE_CAPACITY = 4;
    private final static String PAGE = "page";
    private final static String LEFT_PAGE = "leftPage";
    private final static String RIGHT_PAGE = "rightPage";
    private final static String LEFT_PAGE_CLASS = "leftPageClass";
    private final static String RIGHT_PAGE_CLASS = "rightPageClass";
    private final static String GO_TO_LEFT_PAGE = "controller?action=show_items_page&page=";
    private final static String GO_TO_RIGHT_PAGE = "controller?action=show_items_page&page=";
    private final static String DISABLED_BUTTON = " disabled";
    private final static String NOT_ACTION = "";
    private final static String USER = "user";
    private final static String ITEMS_LIST = "itemsList";
    private final static String MESSAGE = "message";
    private final static String ITEMS_PAGE = "controller?action=show_all_user_items";
    private int pageNumber = 1;
    private ItemService itemService = new ItemService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        User user = (User) request.getSession().getAttribute(USER);
        if (user == null) {
            router.setPagePath(ITEMS_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        String leftPage;
        String leftPageClass;
        String rightPage;
        String rightPageClass;
        ArrayList<Item> itemsList;
        if (request.getParameter(PAGE) != null) {
            pageNumber = Integer.parseInt(request.getParameter(PAGE));
        }
        try {
            itemsList = itemService.findAllByPage(PAGE_CAPACITY, pageNumber);
            int itemCount = itemService.findAll().size();
            if (pageNumber > 1) {
                leftPage = GO_TO_LEFT_PAGE + (pageNumber - 1);
                leftPageClass = NOT_ACTION;
            } else {
                leftPage = NOT_ACTION;
                leftPageClass = DISABLED_BUTTON;
            }
            if (itemCount >= pageNumber * PAGE_CAPACITY) {
                rightPage = GO_TO_RIGHT_PAGE + (pageNumber + 1);
                rightPageClass = NOT_ACTION;
            } else {
                rightPage = NOT_ACTION;
                rightPageClass = DISABLED_BUTTON;
            }
            request.setAttribute(USER, user);
            request.setAttribute(ITEMS_LIST, itemsList);
            request.setAttribute(LEFT_PAGE, leftPage);
            request.setAttribute(LEFT_PAGE_CLASS, leftPageClass);
            request.setAttribute(RIGHT_PAGE, rightPage);
            request.setAttribute(RIGHT_PAGE_CLASS, rightPageClass);
            router.setPagePath(PageConstant.MAIN_PAGE);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
