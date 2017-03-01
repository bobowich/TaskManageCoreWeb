package com.rosin.manager.mobile.bean;

import com.rosin.manager.common.model.User;

/**
 * Created by Administrator on 2017/2/15.
 */
public class LoginResponse {
    int code;
    String message;
    User user;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
