package com.revature.bankingapp.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao {

    public Client create(Client newClient) {

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {
            String sql = "insert into client (fname, lname, uname, pword) values (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newClient.getFname());
            ps.setString(2, newClient.getLname());
            ps.setString(3, newClient.getUname());
            ps.setString(4, newClient.getPword());
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

    public void depositFunds(Client ac, Client funds) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql1 = "update client set new_credit = ? where uname = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, funds.getNew_credit());
            ps1.setString(2, ac.getUname());
            ps1.executeUpdate();
            String sql2 = "update client set balance = balance + new_credit where uname = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, ac.getUname());
            ps2.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void withdrawFunds(Client ac, Client funds) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql1 = "update client set new_debit = ? where uname = ?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, funds.getNew_debit());
            ps1.setString(2, ac.getUname());
            ps1.executeUpdate();
            String sql2 = "update client set balance = balance - new_debit where uname = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, ac.getUname());
            ps2.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public double getBalance(Client s) {
        
        double balance = 0;
        
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "select balance from client where uname = ?";
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