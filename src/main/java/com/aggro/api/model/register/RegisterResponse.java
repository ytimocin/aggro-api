package com.aggro.api.model.register;

/**
 * Created by yeko on 17/10/15.
 */
public class RegisterResponse {

    private int registerResponseCode;
    private String registerResponseDesc;

    public int getRegisterResponseCode() {
        return registerResponseCode;
    }

    public void setRegisterResponseCode(int registerResponseCode) {
        this.registerResponseCode = registerResponseCode;
    }

    public String getRegisterResponseDesc() {
        return registerResponseDesc;
    }

    public void setRegisterResponseDesc(String registerResponseDesc) {
        this.registerResponseDesc = registerResponseDesc;
    }
}
