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

public class FindItemAction implements Action {
    private final static String FIND_PARAMS = "findString";
    private final static String MESSAGE = "message";
    private final static String ITEMS_LIST = "itemsList";
    private final ItemService itemService = new ItemService();


    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();

        String params = request.getParameter(FIND_PARAMS);
        ArrayList<Item> itemsList = new ArrayList<>();
        ArrayList<Item> foundedItemsList = new ArrayList<>();

        Item item = new Item();
//TODO if is an appropriate util?


        String[] words = params.split(" ");
        try {
            itemsList = itemService.findAll();

            for (Item item1 : itemsList) {
                for (String word : words) {
                    if (item1.getName().contains(word)) //||
                          // item1.getModel().contains(word)) {
                        //TODO: add? type & unit
                    {
                        foundedItemsList.add(item1);
                    } else if (item1.getDescription() != null)
                        if (item1.getDescription().contains(word)) {
                            foundedItemsList.add(item1);
                        }
                }
                request.setAttribute(ITEMS_LIST, foundedItemsList);
                router.setPagePath(PageConstant.ITEM_FIND);
            }
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);

        }

        return router;
    }
}