package com.aggro.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;

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
    private LinkedList<String> badges;

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

    public LinkedList<String> getBadges() {
        return badges;
    }

    public void setBadges(LinkedList<String> badges) {
        this.badges = badges;
    }
}