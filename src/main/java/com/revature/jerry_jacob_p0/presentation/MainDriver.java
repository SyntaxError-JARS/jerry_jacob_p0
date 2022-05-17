package com.revature.jerry_jacob_p0.presentation;

import com.revature.jerry_jacob_p0.data.Client;
import com.revature.jerry_jacob_p0.service.ClientServices;

public class MainDriver {

    public static void main(String[] args) {

        ClientServices cs = new ClientServices();

        /*
        Client newClient = new Client("jerry", "jacob", "jj123", "xyz", 50);
        cs.createAccount(newClient);
        */

        Client someone = new Client("jj12", "xyz");
        boolean flag = cs.login(someone);
        if (flag == true) {
            System.out.println("Logged in");
        }
        else System.out.println("Could not log you in");

        /*
        cs.depositFunds();
        cs.withdrawFunds();
        cs.viewBalance();
        */
    }
}
