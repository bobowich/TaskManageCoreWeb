package com.rosin.manager.mobile.serviceImpl;

import com.rosin.manager.common.dao.UserMapper;
import com.rosin.manager.common.model.User;
import com.rosin.manager.mobile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by Administrator on 2017/2/25.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public User findUserByUsername(String username) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-context-mybatis.xml");
//        userMapper = (UserMapper) ac.getBean("userMapper");
        User user = userMapper.selectUserByUsername(username);
        return user;
    }

}
