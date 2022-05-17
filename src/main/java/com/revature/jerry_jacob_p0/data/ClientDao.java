package com.revature.jerry_jacob_p0.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDao {

    public Client create(Client newClient) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "insert into client (fname, lname, uname, pword, balance) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newClient.getFname());
            ps.setString(2, newClient.getLname());
            ps.setString(3, newClient.getUname());
            ps.setString(4, newClient.getPword());
            ps.setDouble(5, newClient.getBalance());
            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0) {
                throw new RuntimeException();
            }

        } catch (SQLException | RuntimeException e) {
            e.printStackTrace();
            return null;
        }
        return newClient;
    }
}
