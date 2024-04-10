package com.gourianova.acoustic.action.admin.item;

import com.gourianova.acoustic.Construct;
import com.gourianova.acoustic.Material;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.ConstructService;
import com.gourianova.acoustic.service.MaterialService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ShowAddItemPageAction implements Action {
    private final static String TYPES_LIST = "constructsList";
    private final static String SOURCE_UNIT = "materialsList";
    private final static String ITEM_ID = "itemId";

    private final static String MESSAGE = "message";
    private final ConstructService constructService = new ConstructService();
    private final MaterialService materialService = new MaterialService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        ArrayList<Construct> typesList;
        ArrayList<Material> unitsList;

        try {
            typesList = constructService.findAll();
            unitsList = materialService.findAll();
            request.setAttribute(TYPES_LIST, typesList);
            request.setAttribute(SOURCE_UNIT, unitsList);

            router.setPagePath(PageConstant.ADD_ITEM);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
