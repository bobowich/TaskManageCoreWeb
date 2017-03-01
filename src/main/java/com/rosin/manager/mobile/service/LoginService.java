package com.rosin.manager.mobile.service;

import com.rosin.manager.common.model.User;

/**
 * Created by Administrator on 2017/2/14.
 */
public interface LoginService {
    User checkLogin(String username,String password);
}
