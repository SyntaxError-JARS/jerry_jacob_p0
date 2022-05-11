package com.revature.bankingapp.daos;

import com.revature.bankingapp.models.User;
import com.revature.bankingapp.util.ConnectionFactory;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.*;
import java.sql.*;

public class UserDao implements Crudable<User> {

    @Override
    public User create(User newUser) {
        System.out.println("Here is the newUser as it enters our DAO layer: " + newUser); // What happens here? Java knows to invoke the toString() method when printing the object to the terminal

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            // NEVER EVER EVER EVER EVER concatenate or directly use these strings inside of the sql statement
            // String sql = "insert into trainer value (" + newTrainer.getFname() + "," + newTrainer.getLname();

            // The commented out sql String is using default for auto-generating the ID ifyou used serial
            // String sql = "insert into trainer values (default, ?, ?, ?, ?, ?)"; // incomplete sql statement, with default if not specifiying columns
            String sql = "insert into bankuser (fname, lname, uname, pword) values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            System.out.println(newUser.getFname());
            System.out.println(newUser.getLname());

            // 1-indexed, so first ? starts are 1
            ps.setString(1, newUser.getFname());
            ps.setString(2, newUser.getLname());
            ps.setString(3, newUser.getUname());
            ps.setString(4, newUser.getPword());


            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0) {
                throw new RuntimeException();
            }

        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
            return null;
        }
        return newUser;
    }

    public User[] findAll() throws IOException {

        // making an array of Trainer classes, and seetting it to a max size of 10
        User[] users = new User[10];
        // declaring index variable as an int and intiliazation witht he value of 0
        int index = 0; // we want to keep track of where we are placing each trainer from the file into the the array

        // TODO: we trying something here and passing an argumetn???
        try (Connection conn = ConnectionFactory.getInstance().getConnection();) { // try with resoruces, because Connection extends the interface Auto-Closeable

            String sql = "select * from bankuser";
            Statement s = conn.createStatement();

            // conn.createStatement().executeQuery("select * from trainer"); fine but generally not used
            // TODO: Hey why are we using the sql variable string here?
            ResultSet rs =s.executeQuery(sql);

            while (rs.next()) { // the last line of the file is null
                User user = new User();

                user.setFname(rs.getString("fname")); // this column lable MUST MATCH THE DB
                user.setLname(rs.getString("lname"));
                user.setUname(rs.getString("uname"));
                user.setPword(rs.getString("pword"));


                System.out.println("Inserted user into index" + index);
                users[index] = user;
                index++; // increment the index by 1, must occur after the trainer[index] re-assignment
                System.out.println("Going to the next line for our following index.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }



        System.out.println("Returning users infomation to user.");
        return users;
    }

    @Override
    public User findById(String id) {


        try(Connection conn = ConnectionFactory.getInstance().getConnection();){

            String sql = "select * from bankuser where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, Integer.parseInt(id)); // Wrapper class example

            ResultSet rs = ps.executeQuery(); // remember dql, bc selects are the keywords

            User user = new User();

            user.setFname(rs.getString("fname")); // this column lable MUST MATCH THE DB
            user.setLname(rs.getString("lname"));
            user.setUname(rs.getString("uname"));
            user.setPword(rs.getString("pword"));


            return user;

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean update(User updatedObj) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}