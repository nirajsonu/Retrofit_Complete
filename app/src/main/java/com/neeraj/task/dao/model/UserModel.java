package com.neeraj.task.dao.model;

public class UserModel {
    private String username;
    private String password;
    private String mobile_no;

    public UserModel(String username, String password, String mobile_no) {
        this.username = username;
        this.password = password;
        this.mobile_no = mobile_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }
    public void user()
    {

    }
}
