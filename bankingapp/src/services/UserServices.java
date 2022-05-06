package services;

import daos.UserDao;
import models.User;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserServices {

    private UserDao userDao = new UserDao();

    public boolean registerUser(User newUser) {
        System.out.println("User trying to be registered: " + newUser);
        User persistedUser = userDao.create(newUser);

        if (persistedUser == null) {
            throw new RuntimeException();
        }
        System.out.println("User has been persisted: " + newUser);
        return true;
    }
}
