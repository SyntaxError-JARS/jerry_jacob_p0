package models;

public class User {
    private String fname;
    private String lname;
    private String uname;
    private String pword;

    public User(String fname, String lname, String uname, String pword) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.pword = pword;
    }

    public User() {}

    public String getFname() { return fname; }
    public String getLname() { return lname; }
    public String getUname() { return uname; }
    public String getPword() { return pword; }
    public void setFname(String fname) { this.fname = fname; }
    public void setLname(String lname) { this.lname = lname; }
    public void setUname(String uname) { this.uname = uname; }
    public void setPword(String pword) { this.pword = pword; }

    public String toFileString() {
        StringBuilder mutableString = new StringBuilder();
        mutableString
                .append(fname).append(",")
                .append(lname).append(",")
                .append(uname).append(",")
                .append(pword);
        return mutableString.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", uname='" + uname + '\'' +
                ", pword='" + pword + '\'' +
                '}';
    }






}
