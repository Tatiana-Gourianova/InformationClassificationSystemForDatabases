package com.gourianova.acoustic.action.admin.user;

import com.gourianova.acoustic.User;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.UserService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeUserDataAction implements Action {
    //  private final static String LOGIN = "login";
    // private final static String PASSWORD = "password";
    private final static String MESSAGE = "message";
    private final static String USER_ID = "userId";
    private final static String ROLE_ID = "roleId";
    private UserService userService = new UserService();
    private String password;

    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        User user = new User();
        if (request.getParameter(USER_ID) != null) {
            user.setId(Integer.parseInt(request.getParameter(USER_ID)));
        }
        //    password = request.getParameter(PASSWORD);
        //   password = MD5.md5Encode(password);
        try {
            user.setId(Integer.parseInt(request.getParameter(USER_ID)));
            userService.updateUser(user);
            router.setPagePath(PageConstant.ADMIN_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }

}
