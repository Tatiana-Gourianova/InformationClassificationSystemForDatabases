package com.gourianova.acoustic.action.admin.tmp;

import com.gourianova.acoustic.Role;
import com.gourianova.acoustic.User;
import com.gourianova.acoustic.action.Action;
import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;
import com.gourianova.acoustic.service.RoleService;
import com.gourianova.acoustic.service.UserService;
import com.gourianova.acoustic.util.PageConstant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class ChangeUserAction implements Action {
    private final static String USER_ID = "userId";
    private final static String ROLE_ID = "roleId";
    private final static String MESSAGE = "message";
    private final static String ROLES_LIST = "rolesList";
    private final static String ADMIN_PAGE = "/controller?action=show_admin_page";
    private UserService userService = new UserService();
    private RoleService roleService = new RoleService();

    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Router router = new Router();
        User user = new User();
        try {
            user.setId(Integer.parseInt(request.getParameter(USER_ID)));
            user.setRoleId(Integer.parseInt(request.getParameter(ROLE_ID)));
            userService.updateUser(user);
            ArrayList<Role> rolesList;
            rolesList = roleService.findAll();
            request.setAttribute(ROLES_LIST, rolesList);
            router.setPagePath(ADMIN_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        } catch (ServiceException e) {
            request.getSession().setAttribute(MESSAGE, e.getMessage());
            router.setPagePath(PageConstant.ERROR_PAGE);
            router.setRoute(Router.RouteType.REDIRECT);
        }
        return router;
    }
}
