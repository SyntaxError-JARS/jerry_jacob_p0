package com.revature.jerry_jacob_p0.service;

import com.revature.jerry_jacob_p0.data.Client;
import com.revature.jerry_jacob_p0.data.ClientDao;

public class ClientServices {

    private ClientDao clientDao = new ClientDao();

    public boolean createAccount(Client newClient) {
        Client createdAccount = clientDao.create(newClient);
        if (createdAccount == null) {
            throw new RuntimeException();
        }
        return true;
    }

    public boolean login(Client s) {
        if(s.getUname() == null || s.getUname().trim().equals("") || s.getPword() == null || s.getPword().trim().equals("")) {
            throw new RuntimeException();
        }
        boolean flag = clientDao.authenticateClient(s);
        return flag;

    }
}
