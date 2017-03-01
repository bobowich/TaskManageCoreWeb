package com.rosin.manager.admin.serviceImpl;

import com.rosin.manager.admin.service.AdminLoginService;
import com.rosin.manager.common.dao.AdminMapper;
import com.rosin.manager.common.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/23.
 */
@Service("adminLoginService")
public class AdminLoginServiceImpl implements AdminLoginService{

//    @Autowired
//    AdminMapper adminMapper;

//    public Admin checkLogin(String name, String password) {
////        Admin admin = adminMapper.selectByAdminNameAndPassword(name, password);
////        return admin;
//        return null;
//    }

    public Admin checkAdmin(String username, String password) {
        return null;
    }
}
