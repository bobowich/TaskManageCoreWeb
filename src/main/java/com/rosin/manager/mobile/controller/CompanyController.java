package com.rosin.manager.mobile.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rosin.manager.common.json.JSON;
import com.rosin.manager.common.model.Company;
import com.rosin.manager.common.model.User;
import com.rosin.manager.mobile.serviceImpl.CompanyServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

    private static Logger logger = Logger.getLogger(CompanyController.class);

    @Autowired
    CompanyServiceImpl companyService;

    @RequestMapping("/getAll")
    @JSON(type = User.class,include = "companyName,realName")
    public PageInfo<Company> getAllCompanies(@RequestParam(value = "pageSize",required = false) int pageSize,
                                             @RequestParam(value = "pageIndex",required = false) int pageIndex){
        PageHelper.startPage(pageIndex, pageSize);
        List<Company> companyList = companyService.getAllCompanies();
        PageInfo<Company> pageInfo = new PageInfo<Company>(companyList);
        return pageInfo;
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateCompany(@RequestParam("companyId") int companyId
            ,@RequestParam("companyName")String companyName) {
        Company company = new Company();
        company.setCompanyId(companyId);
        company.setCompanyName(companyName);
        int index = companyService.updateByPrimaryKeySelective(company);
        return "success";
    }

    @RequestMapping("/del")
    @ResponseBody
    public String deleteCompany(@RequestBody List<Company> companies) {
        int index = companyService.deleteByPrimaryKey(companies);
        logger.info("index" + ":" + index);
        return "success";
    }
}
