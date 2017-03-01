package com.rosin.manager.mobile.serviceImpl;

import com.rosin.manager.common.dao.UserMapper;
import com.rosin.manager.common.model.User;
import com.rosin.manager.mobile.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/14.
 */

@Service("loginService")
public class LoginServiceImpl implements LoginService{

//    @Autowired
//    UserMapper userMapper;


    public User checkLogin(String username,String password) {
//        User user = userMapper.selectUserByNameAndPassword(username,password);
        return null;
    }
}
