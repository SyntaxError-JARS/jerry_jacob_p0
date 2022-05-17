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
}
