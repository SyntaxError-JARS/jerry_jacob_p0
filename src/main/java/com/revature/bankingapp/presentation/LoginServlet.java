package com.revature.bankingapp.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bankingapp.data.Client;
import com.revature.bankingapp.service.ClientServices;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final ClientServices cs;
    private final ObjectMapper mapper;

    private Client authenticatedClient;

    public LoginServlet(ClientServices cs, ObjectMapper mapper) {
        this.cs = cs;
        this.mapper = mapper;
    }
    // ------------LOGIN------------
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Client someone = mapper.readValue(req.getInputStream(), Client.class);
        boolean flag = cs.login(someone);
        if (flag == true) {
            authenticatedClient = someone;
            resp.getWriter().write("Logged in");
            resp.setStatus(200);
        } else {
            resp.getWriter().write("Could not log you in");
            resp.setStatus(401);
        }
    }
    // ---------DEPOSIT AND WITHDRAWAL--------
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Client funds = mapper.readValue(req.getInputStream(), Client.class);
        if (funds.getNew_credit() > 0) {
            cs.depositFunds(authenticatedClient, funds);
            funds.setNew_credit(0);
            resp.getWriter().write("Click CHECK BALANCE to see your balance. \n");
            resp.getWriter().write("In future version of the app, you will be able to see your balance right here.");
        }
        else if (funds.getNew_debit() > 0) {
            cs.withdrawFunds(authenticatedClient, funds);
            funds.setNew_debit(0);
            resp.getWriter().write("Click CHECK BALANCE to see your balance. \n");
            resp.getWriter().write("In future version of the app, you will be able to see your balance right here.");
        }
        else resp.getWriter().write("Invalid amount");
    }
    //---------VIEW BALANCE---------
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        double balance = cs.viewBalance(authenticatedClient);
        resp.getWriter().write("Your balance is $" + balance);
    }

}