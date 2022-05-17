package com.revature.jerry_jacob_p0.data;

public class Client {
    private String fname;
    private String lname;
    private String uname;
    private String pword;
    private double balance;

    @Override
    public String toString() {
        return "Client{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", uname='" + uname + '\'' +
                ", pword='" + pword + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Client(String fname, String lname, String uname, String pword, double balance) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.pword = pword;
        this.balance = balance;
    }

    public Client(String uname, String pword) {
        this.uname = uname;
        this.pword = pword;
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

    public String toFileString() {
        StringBuilder mutableString = new StringBuilder();
        mutableString
                .append(fname).append(",")
                .append(lname).append(",")
                .append(uname).append(",")
                .append(pword).append(",")
                .append(balance);
        return mutableString.toString();
    }
}
