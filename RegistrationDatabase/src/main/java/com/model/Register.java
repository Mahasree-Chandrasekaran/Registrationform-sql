package com.model;

public class Register {
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String photo;

    public Register(String fname, String lname, String email, String password, String photo) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }

    // Getters and setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
