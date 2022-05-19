package com.revature.bankingapp.service;

import com.revature.bankingapp.data.Client;
import com.revature.bankingapp.data.ClientDao;

public class ClientServices {

    private ClientDao clientDao = new ClientDao();

    public ClientServices(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

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

    public void depositFunds(Client ac, Client funds) {
        clientDao.depositFunds(ac, funds);
    }

    public void withdrawFunds(Client ac, Client funds) {
        clientDao.withdrawFunds(ac, funds);
    }

    public double viewBalance(Client s) {
        double balance = clientDao.getBalance(s);
        return balance;
    }


}