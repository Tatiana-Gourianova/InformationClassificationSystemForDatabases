package com.gourianova.acoustic.action.admin.item;

import com.gourianova.acoustic.Material;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.MaterialService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddMaterialAction implements Action {

    private final static String UNIT = "unit";
    private final static String MESSAGE = "message";

    private MaterialService materialService = new MaterialService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        Router router = new Router();
        Material unit = new Material();

        unit.setUnit(request.getParameter(UNIT));

        try {
            if (materialService.createSensorUnit(unit)) {
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
