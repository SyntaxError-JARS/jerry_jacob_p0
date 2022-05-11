package com.revature.bankingapp;

import com.revature.bankingapp.models.User;
import com.revature.bankingapp.util.AppState;

import java.io.*;

public class MainDriver {

    public static void main(String[] args){

        System.out.println("1. AppState instantiated");
        AppState appState = new AppState();

        System.out.println("Banking Application starting up....");
        appState.startup();
    }
}