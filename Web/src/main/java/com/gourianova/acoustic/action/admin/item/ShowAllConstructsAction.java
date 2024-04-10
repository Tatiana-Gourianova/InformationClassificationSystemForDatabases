package com.gourianova.acoustic.action.admin.item;

import com.gourianova.acoustic.Construct;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.ConstructService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ShowAllConstructsAction implements Action {
    private final static String TYPES_LIST = "constructsList";
    private final static String MESSAGE = "message";
    private ConstructService constructService = new ConstructService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        ArrayList<Construct> typesList;
        try {
            typesList = constructService.findAll();
            request.setAttribute(TYPES_LIST, typesList);
            router.setPagePath(PageConstant.ALL_CONSTRUCT);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
