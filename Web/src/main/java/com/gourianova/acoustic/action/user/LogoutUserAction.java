package com.gourianova.acoustic.action.user;

import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LogoutUserAction implements Action {
    private final static String USER = "user";
    private final static String INVALIDATE = "invalidate";

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        HttpSession session = request.getSession();
        session.removeAttribute(USER);
        session.setAttribute(INVALIDATE, Boolean.TRUE);
        router.setPagePath(PageConstant.FIRST_PAGE);
        router.setRoute(Router.RouteType.REDIRECT);
        return router;
    }
}
