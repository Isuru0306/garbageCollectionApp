package com.garbagecollections.utils.models;

public class UserHelper {
    private String name, email, username, password, user_type;

    public UserHelper() {
    }

    public UserHelper(String name, String email, String username, String password, String user_type) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
    }

    public UserHelper(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserHelper(String name, String email, String user_type) {
        this.name = name;
        this.email = email;
        this.user_type = user_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

}
