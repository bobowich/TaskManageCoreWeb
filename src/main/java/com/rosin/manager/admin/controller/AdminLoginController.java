package com.rosin.manager.admin.controller;

import com.rosin.manager.admin.service.AdminLoginService;
import com.rosin.manager.common.model.Admin;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/2/23.
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    private static Logger logger = Logger.getLogger(AdminLoginController.class);
    @Autowired
    AdminLoginService adminLoginService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String adminLogin(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.info("AdminLoginController--adminLogin--" + username + "--" + password);
        Admin admin = adminLoginService.checkAdmin(username, password);
        if (admin == null) {
            return "fail";
        } else {
            logger.info(admin);
            return "success";
        }
    }
}
