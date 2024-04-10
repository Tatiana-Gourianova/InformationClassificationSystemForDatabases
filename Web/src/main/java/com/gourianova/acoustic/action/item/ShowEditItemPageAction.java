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

public class ShowEditItemPageAction implements Action {
    private final static String CONSTRUCTS_LIST = "constructList";
    private final static String MATERIALS_LIST = "materialsList";
    private final static String ITEMS_LIST = "itemsList";
    private final static String ITEM_ID = "itemId";
    private final static String ITEM = "item";
    private final static String MESSAGE = "message";
    //  private final static String EDIT_PAGE = "/includeAdmin/edit_item.jsp";

    //private ConstructService constructService = new ConstructService();
    //private MaterialService materialService = new MaterialService();
    private final ItemService itemService = new ItemService();

    //TODO: fix EDIT/UPDATE mode and insert on main_page.jsp
    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {
        Router router = new Router();
        Item item = new Item();
        // if(request.getParameterValues(ITEM_ID)!=null) { TODO

        System.out.println("ShowEditItemPageAction ");
        try {
            item = itemService.findItemById(Integer.parseInt(request.getParameter(ITEM_ID)));
            request.setAttribute(ITEM, item);
            router.setPagePath(PageConstant.EDIT_ITEM);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
     /*   Router router = new Router();
        //ArrayList<Construct> constructsList;
      //  ArrayList<Material> materialsList;
        ArrayList<Item> itemsList;
        System.out.println("ShowEditItemPageAction");
        int id;
        try {
            String ID = request.getParameter(ITEM_ID);
            System.out.println(ID);
            id = Integer.parseInt(ID);
         Item item = itemService.findItemById(id);
          //                 constructsList = constructService.findAll();
            //   materialsList = materialService.findAll();
               request.setAttribute(ITEM, item);
          //  request.setAttribute(CONSTRUCTS_LIST, constructsList);
           // request.setAttribute(MATERIALS_LIST, materialsList);
            router.setPagePath(EDIT_PAGE);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }

      */
}
