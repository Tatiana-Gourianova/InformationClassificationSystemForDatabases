package com.gourianova.acoustic.action.user;

import com.gourianova.acoustic.User;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.UserService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginUserAction implements Action {
    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";
    private final static String USER = "user";
    private final static String WRONG_LOGIN_PASSWORD = "wrongLoginPassword";
    private final static String MESSAGE = "message";
    private final static String REFERRER = "referrer";
    private UserService userService = new UserService();


    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        try {
            User user = userService.findUserByLoginAndPassword(login, password);
            if (user != null) {
                session.setAttribute(USER, user);
                router.setPagePath(PageConstant.FIRST_PAGE);
                router.setRoute(Router.RouteType.REDIRECT);
            } else {
                request.setAttribute(WRONG_LOGIN_PASSWORD, Boolean.TRUE);
                router.setPagePath(PageConstant.LOGIN_PAGE);
                request.getSession().setAttribute(REFERRER, PageConstant.LOGIN_PAGE);
            }
        } catch (ServiceException e) {
            session.setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
