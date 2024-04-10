package com.gourianova.acoustic.action.admin.item;

import com.gourianova.acoustic.Construct;
import com.gourianova.acoustic.Construction;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.ConstructService;
import com.gourianova.acoustic.service.ConstructionService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddConstructionAction implements Action {

    private final static String TITLE = "title";
    private final static String MESSAGE = "message";

    private ConstructionService constructionService = new ConstructionService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        Router router = new Router();
        Construction construction = new Construction();

        construction.setTitle(request.getParameter(TITLE));

        try {
            if (constructionService.createItemType(construction)) {
                request.setAttribute(MESSAGE, "The item is added");
                router.setPagePath(PageConstant.ADMIN_PAGE);
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
