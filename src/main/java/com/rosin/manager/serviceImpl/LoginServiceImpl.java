package com.rosin.manager.serviceImpl;

import com.rosin.manager.dao.UserMapper;
import com.rosin.manager.model.User;
import com.rosin.manager.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/2/14.
 */

@Service("userService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    UserMapper userMapper;


    public User checkLogin(String username,String password) {
        User user = userMapper.selectUserByNameAndPassword(username,password);
        return user;
    }
}
