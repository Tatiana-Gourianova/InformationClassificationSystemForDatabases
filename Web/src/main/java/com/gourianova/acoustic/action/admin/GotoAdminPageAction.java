package com.gourianova.acoustic.action.admin;

import com.gourianova.acoustic.Construction;
import com.gourianova.acoustic.Item;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.*;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GotoAdminPageAction implements Action {
    private final static String USERS_LIST = "usersList";
    private final static String ITEMS_LIST = "itemsList";
    private final static String MATERIALS_LIST = "materialsList";
    private final static String CONSTRUCTS_LIST = "constructsList";
    private final static String CONSTRUCTIONS_LIST = "constructionsList";
    private final static String MESSAGE = "message";
    private UserService userService = new UserService();
    private ItemService itemsService = new ItemService();
    private MaterialService materialService = new MaterialService();
    private ConstructService constructService = new ConstructService();
    private ConstructionService constructionService = new ConstructionService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
       // ArrayList<User> usersList;
        ArrayList<Item> itemsList;
        //ArrayList<Construct>  constructsList;
        ArrayList<Construction>  constructionsList;
        //ArrayList<Material> materialsList;
        System.out.println("ShowAdminPageAction");
        try {
        //    usersList = userService.findAll();
            itemsList = itemsService.findAll();
           //constructsList = constructService.findAll();
           constructionsList=constructionService.findAll();
           // materialsList = materialService.findAll();
            request.setAttribute(CONSTRUCTIONS_LIST, constructionsList);
            //request.setAttribute(USERS_LIST, usersList);
            request.setAttribute(ITEMS_LIST, itemsList);
           //request.setAttribute(MATERIALS_LIST, materialsList);
           //request.setAttribute(CONSTRUCTS_LIST, constructsList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PageConstant.ADMIN_PAGE);
            requestDispatcher.forward(request, response);
            router.setPagePath(PageConstant.ADMIN_PAGE);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
