package com.rosin.manager.mobile.controller;

import com.rosin.manager.mobile.bean.LoginResponse;
import com.rosin.manager.common.json.JSON;
import com.rosin.manager.common.model.User;
import com.rosin.manager.mobile.serviceImpl.LoginServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Administrator on 2017/2/14.
 */
@Controller
@RequestMapping("/normal")
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    LoginServiceImpl loginService;
//    @RequiresRoles("manager")
    @RequestMapping("/login")
    //@ResponseBody
    //    使用自定义的HandlerMethodReturnValueHandler之后，要注释掉@ResponseBody
    //@JSON(type = User.class,include = "userName,userPassword")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        logger.debug("LoginController--login--" + "username :" + username + "password:" + password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);
        try {
            subject.login(token);
            logger.info("nice");
            return "adminHome";
        } catch (Exception e) {
            logger.info("LoginController--login--e"+"--"+e.getMessage());
        }
//        User user = loginService.checkLogin(username,password);
//        LoginResponse loginResponse = new LoginResponse();
//        loginResponse.setUser(user);
//        if (user == null) {
//            loginResponse.setCode(HttpStatus.NOT_FOUND.value());
//            loginResponse.setMessage(username+"does  not exist!");
//        }else {
//            loginResponse.setCode(200);
//            loginResponse.setMessage("you are right");
//        }
//        logger.debug("LoginController--login--");
//        return loginResponse;
        return "fail";

    }
}
