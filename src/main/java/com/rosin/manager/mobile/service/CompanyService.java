package com.rosin.manager.mobile.service;

import com.rosin.manager.common.model.Company;
import com.rosin.manager.common.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
public interface CompanyService {
    List<Company> getAllCompanies();

    int updateByPrimaryKeySelective(Company company);

    int deleteByPrimaryKey(List<Company> companies);
}
