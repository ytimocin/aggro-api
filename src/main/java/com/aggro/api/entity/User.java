package com.aggro.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by yeko on 16/10/15.
 */
@Document(collection = "AggroUsers")
public class User {

    @Id
    private String aggroID;
    private String username;
    private String email;
    private String password;
    private int badge;

    public String getAggroID() {
        return aggroID;
    }

    public void setAggroID(String aggroID) {
        this.aggroID = aggroID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }
}