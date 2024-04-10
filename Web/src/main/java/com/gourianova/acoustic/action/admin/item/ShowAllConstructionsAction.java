package com.gourianova.acoustic.action.admin.item;

import com.gourianova.acoustic.Construct;
import com.gourianova.acoustic.Construction;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.ConstructService;
import com.gourianova.acoustic.service.ConstructionService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ShowAllConstructionsAction implements Action {
    private final static String CONSTRUCTIONS_LIST = "constructionsList";
    private final static String MESSAGE = "message";
    private ConstructionService constructionService = new ConstructionService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        ArrayList<Construction> constructionsList;
        try {
            constructionsList = constructionService.findAll();
            request.setAttribute(CONSTRUCTIONS_LIST,  constructionsList);
            router.setPagePath(PageConstant.ALL_CONSTRUCTION);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
