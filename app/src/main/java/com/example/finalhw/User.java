package com.example.finalhw;

public class User {
    private String uid;
    private String name;
    private String email;
    private String password;
    private String token;   //for fcm(firebase cloud message)
    public User() {
        //required for firebase
    }

    public User(String uid, String token) {
        this.uid = uid;
        this.token = token;
    }

    public User(String uid, String name, String email, String password) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
