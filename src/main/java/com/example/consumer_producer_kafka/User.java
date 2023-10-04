package com.example.consumer_producer_kafka;


import com.fasterxml.jackson.annotation.JsonProperty;

public class User{
    private String login;
    private String password;
    private String date;
    private String email;

    public User(@JsonProperty("login") String login, @JsonProperty("password") String password,
                @JsonProperty("date") String date, @JsonProperty("email") String email){
        this.login = login;
        this.password = password;
        this.date = date;
        this.email = email;
    }

    @Override
    public String toString(){
        return "{\"login\":\"" + login + "\", \"password\":\"" + password + "\", \"date\":\"" + date + "\", \"email\":\"" + email + "\"}";
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

