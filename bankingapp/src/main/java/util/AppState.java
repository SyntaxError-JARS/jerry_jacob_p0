package com.revature.bankingapp.util;

import com.revature.bankingapp.menus.RegisterMenu;
import com.revature.bankingapp.services.UserServices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private static boolean isRunning;

    private RegisterMenu registerMenu;
    // once we add register we will need private final MenuRouter router;

    public AppState() {
        System.out.println("2. Generating instance of AppState.");
        isRunning = true;
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
        UserServices userServices = new UserServices();

        // TODO: Why are we doing all of this!?

        this.registerMenu = new RegisterMenu(terminalReader);
    }

    public void startup(){
        try {
            while(isRunning) {
                System.out.println("Application successfully started");
                registerMenu.render();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdown(){
        isRunning = false;
        System.out.println("Application shutting down...");
    }

}
