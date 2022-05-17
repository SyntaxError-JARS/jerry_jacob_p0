package com.revature.jerry_jacob_p0.presentation;

import com.revature.jerry_jacob_p0.data.Client;
import com.revature.jerry_jacob_p0.service.ClientServices;

public class MainDriver {

    public static void main(String[] args) {
        Client newClient = new Client("jerry", "jacob", "jj123", "xyz", 50);
        ClientServices cs = new ClientServices();
        cs.createAccount(newClient);

        /*
        cs.login();
        cs.depositFunds();
        cs.withdrawFunds();
        cs.viewBalance();
        */
    }
}
