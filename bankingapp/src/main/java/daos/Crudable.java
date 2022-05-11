package com.revature.bankingapp.daos;

import java.io.FileNotFoundException;
import java.io.IOException;

// This is another form of abstraction
public interface Crudable<U> {

    // public final int age = 16; we call a constant variable because by default it's final and cannot changed

    // Create
    U create(U newObject);

    // Read
    U[] findAll() throws IOException;
    U findById(String id);

    // Update
    public boolean update(U updatedObj);

    //Delete
    boolean delete(String id);

}
