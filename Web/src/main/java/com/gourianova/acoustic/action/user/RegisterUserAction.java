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

//import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class RegisterUserAction implements Action {
    private final static String FIRST_NAME = "first_name";
    private final static String LAST_NAME = "last_name";
    private final static String LOGIN = "login";
    private final static String PASSWORD = "password";
    private final static String USER = "user";
    private final static String WRONG_REGISTER_DATA = "wrongRegisterData";
    private final static String WRONG_USER = "wrongUser";
    private final static String MESSAGE = "message";
    private final static String REFERRER = "referrer";
    private UserService userService = new UserService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();

        User user = new User();

        HttpSession session = request.getSession();
        user.setFirstName(request.getParameter(FIRST_NAME));
        user.setLastName(request.getParameter(LAST_NAME));
        user.setLogin(request.getParameter(LOGIN));
        user.setPassword(request.getParameter(PASSWORD));
        user.setRoleId(new Integer(7));

        try {
            if (userService.validateUser(user) != null) {

                request.setAttribute(WRONG_REGISTER_DATA, userService.validateUser(user));
                router.setPagePath(PageConstant.REGISTER_PAGE);
                request.getSession().setAttribute(REFERRER, PageConstant.REGISTER_PAGE);

            } else if (userService.registerUser(user)) {
                User newUser = userService.findUserByLoginAndPassword(user.getLogin(), request.getParameter(PASSWORD));
                session.setAttribute(USER, newUser);
                router.setPagePath(PageConstant.FIRST_PAGE);
                router.setRoute(Router.RouteType.REDIRECT);
            } else {
                request.setAttribute(WRONG_USER, Boolean.TRUE);
                router.setPagePath(PageConstant.REGISTER_PAGE);
                request.getSession().setAttribute(REFERRER, PageConstant.REGISTER_PAGE);
            }
        } catch (ServiceException e) {
            session.setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
