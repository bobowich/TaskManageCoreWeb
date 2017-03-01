package com.rosin.manager.mobile.serviceImpl;

import com.rosin.manager.common.dao.CompanyMapper;
import com.rosin.manager.common.model.Company;
import com.rosin.manager.common.model.User;
import com.rosin.manager.mobile.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */
@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    public List<Company> getAllCompanies() {
        List<Company> companies = companyMapper.getAllCompanies();
        return companies;
    }

    public int updateByPrimaryKeySelective(Company company) {
        int index = companyMapper.updateByPrimaryKeySelective(company);
        return index;
    }

    public int deleteByPrimaryKey(List<Company> companies) {
        int index = companyMapper.deleteByPrimaryKey(companies);
        return index;
    }


}
