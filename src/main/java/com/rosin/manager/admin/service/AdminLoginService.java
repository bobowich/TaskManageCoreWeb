package com.rosin.manager.admin.service;

import com.rosin.manager.common.model.Admin;

/**
 * Created by Administrator on 2017/2/23.
 */
public interface AdminLoginService {
    Admin checkAdmin(String username, String password);
}
