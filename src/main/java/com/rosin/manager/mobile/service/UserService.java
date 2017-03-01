package com.rosin.manager.mobile.service;

import com.rosin.manager.common.dao.UserMapper;
import com.rosin.manager.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/2/25.
 */
public interface UserService {

    User findUserByUsername(String username);

}
