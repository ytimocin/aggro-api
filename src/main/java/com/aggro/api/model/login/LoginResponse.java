package com.aggro.api.model.login;

import com.aggro.api.entity.User;

/**
 * Created by yeko on 17/10/15.
 */
public class LoginResponse {

    public int loginResponseCode;
    public String loginResponseDesc;
    public User loggedInUser;

    public int getLoginResponseCode() {
        return loginResponseCode;
    }

    public void setLoginResponseCode(int loginResponseCode) {
        this.loginResponseCode = loginResponseCode;
    }

    public String getLoginResponseDesc() {
        return loginResponseDesc;
    }

    public void setLoginResponseDesc(String loginResponseDesc) {
        this.loginResponseDesc = loginResponseDesc;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}
