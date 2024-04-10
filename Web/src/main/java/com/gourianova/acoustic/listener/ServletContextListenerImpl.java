package com.gourianova.acoustic.listener;

import com.gourianova.acoustic.db.ConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ConnectionPool.getInstance().closeConnectionPool();
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }
}
