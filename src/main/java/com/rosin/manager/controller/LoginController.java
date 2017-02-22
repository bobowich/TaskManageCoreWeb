package com.rosin.manager.controller;

import com.rosin.manager.bean.LoginResponse;
import com.rosin.manager.json.JSON;
import com.rosin.manager.model.User;
import com.rosin.manager.serviceImpl.LoginServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2017/2/14.
 */
@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    LoginServiceImpl loginService;

    @RequestMapping("/login")
//    使用自定义的HandlerMethodReturnValueHandler之后，要注释掉@ResponseBody
//    @ResponseBody
    @JSON(type = User.class,include = "userName,userPassword")
    public LoginResponse login(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        //String username = request.getParameter("username");
        //String password = request.getParameter("password");
        System.out.println(username+"..."+password);
        logger.debug("LoginController--login--");
        User user = loginService.checkLogin(username,password);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUser(user);
        if (user == null) {
            loginResponse.setCode(HttpStatus.NOT_FOUND.value());
            loginResponse.setMessage(username+"does  not exist!");
        }else {
            loginResponse.setCode(200);
            loginResponse.setMessage("you are right");
        }
        logger.debug("LoginController--login--");
        return loginResponse;
    }
}
