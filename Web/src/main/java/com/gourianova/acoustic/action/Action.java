package com.gourianova.acoustic.action;

import com.gourianova.acoustic.controller.Router;
import com.gourianova.acoustic.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    Router execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException;
}
