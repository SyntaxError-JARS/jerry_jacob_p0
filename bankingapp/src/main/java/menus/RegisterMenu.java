package com.revature.bankingapp.menus;

import com.revature.bankingapp.models.User;
import com.revature.bankingapp.services.UserServices;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Inheritance from menu abstract class :D another pillar of OOP
public class RegisterMenu extends Menu{

    private UserServices userServices = new UserServices();

    public RegisterMenu(BufferedReader terminalReader) {
        super("Register", "/register", terminalReader);
    }

    // Polymorphism  Another pillar of OOP for the same thing doing different things
    // This is overriding a method
    @Override
    public void render() throws Exception {
        // TODO: Implement me!!!
        System.out.println("What is your full name?");
        String fullName = terminalReader.readLine();

        System.out.println("What username do you want?");
        String uname = terminalReader.readLine();

        System.out.println("What is your password?");
        String pword = terminalReader.readLine();

        System.out.println("Re-enter password");
        String passwordCheck = terminalReader.readLine();



        // What's happening here???
        // Breaking or splitting the String fullName into an String array by " " spaces
        String[] nameArray = fullName.split(" ");
        String fname = nameArray[0];
        String lname = nameArray[1];

        // What's happening here??
        //
        if (!pword.equals(passwordCheck)) { // password != passwordCheck
            System.out.println("Passwords don't match");
            return; // why return??? Control Flow, this breaks this method and returns us to main
        }


        // Trainer trainer = new Trainer(); // why is this red?? there isn't a No-Arg constructor
        // What's happening here? Intialization a new Trainer object in memory
        User newUser = new User(fname, lname, uname, pword);
        System.out.println("Here is the info that was provided by the user: " + newUser);
        userServices.registerUser(newUser);
    }
}