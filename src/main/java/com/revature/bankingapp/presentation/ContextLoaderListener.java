package com.revature.bankingapp.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bankingapp.data.ClientDao;
import com.revature.bankingapp.service.ClientServices;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ObjectMapper mapper = new ObjectMapper();

        ClientDao clientDao = new ClientDao();

        ClientServices cs = new ClientServices(clientDao);

        RegisterServlet rs = new RegisterServlet(cs, mapper);
        LoginServlet ls = new LoginServlet(cs, mapper);

        ServletContext context = sce.getServletContext();
        context.addServlet("RegisterServlet", rs).addMapping("/register");
        context.addServlet("LoginServlet", ls).addMapping("/login");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        ServletContextListener.super.contextDestroyed(sce);
    }
}