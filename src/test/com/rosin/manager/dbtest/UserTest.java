package com.rosin.manager.dbtest;

import com.rosin.manager.common.model.Permission;
import com.rosin.manager.common.model.Role;
import com.rosin.manager.common.model.User;
import com.rosin.manager.mobile.serviceImpl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-mybatis.xml")
public class UserTest {
    private static Logger logger = Logger.getLogger(UserTest.class);

    @Autowired
    UserServiceImpl userService;

    @Test
    public void userDbTest() {
        User user = userService.findUserByUsername("rosin");
        logger.info("UserTest--userDbTest--"+"rosin");
        if (user != null) {
            Role role = user.getRole();
            logger.info("UserTest--userDbTest--" + role.getRoleName());
            List<Permission> permissionList = role.getPermissions();
            for (Permission p:permissionList) {
                logger.info("UserTest--userDbTest--" + p.getPermName() );
            }
        }
    }
}
