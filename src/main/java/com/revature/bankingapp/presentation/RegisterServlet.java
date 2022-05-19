package com.revature.bankingapp.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bankingapp.data.Client;
import com.revature.bankingapp.service.ClientServices;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private final ClientServices cs;
    private final ObjectMapper mapper;

    public RegisterServlet(ClientServices cs, ObjectMapper mapper) {
        this.cs = cs;
        this.mapper = mapper;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Client newClient = mapper.readValue(req.getInputStream(), Client.class);
        cs.createAccount(newClient);
        resp.getWriter().write("Account created");
        resp.setStatus(201);
    }
}