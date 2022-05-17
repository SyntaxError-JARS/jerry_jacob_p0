package com.revature.jerry_jacob_p0.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public boolean authenticateClient(Client s) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "select * from client where uname = ? and pword = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getUname());
            ps.setString(2, s.getPword());

            ResultSet rs = ps.executeQuery();

            if(!rs.isBeforeFirst()){
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void depositFunds(Client s, double funds) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "update client set balance = balance + ? where uname = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, funds);
            ps.setString(2, s.getUname());

            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void withdrawFunds(Client s, double funds) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "update client set balance = balance - ? where uname = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, funds);
            ps.setString(2, s.getUname());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public double balance;
    public double getBalance(Client s) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "select * from client where uname = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getUname());

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {balance = rs.getDouble("balance");}



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return balance;

    }
}
