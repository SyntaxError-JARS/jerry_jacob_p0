package com.revature.bankingapp.data;

public class Client {
    private String fname;
    private String lname;
    private String uname;
    private String pword;
    private double balance;
    private double new_credit;
    private double new_debit;
    private double v;

    public Client(String fname, String lname, String uname, String pword) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.pword = pword;
    }

    public Client(String uname, String pword) {
        this.uname = uname;
        this.pword = pword;
    }

    public Client(double v) {
        this.v = v;
    }

    public Client() {}

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getNew_credit() {
        return new_credit;
    }

    public void setNew_credit(double new_credit) {
        this.new_credit = new_credit;
    }

    public double getNew_debit() {
        return new_debit;
    }

    public void setNew_debit(double new_debit) {
        this.new_debit = new_debit;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Client{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", uname='" + uname + '\'' +
                ", pword='" + pword + '\'' +
                ", balance=" + balance +
                ", new_credit=" + new_credit +
                ", new_debit=" + new_debit +
                ", v=" + v +
                '}';
    }
}


