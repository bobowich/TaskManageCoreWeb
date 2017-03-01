package com.rosin.manager.common.dao;

import com.rosin.manager.common.model.Company;
import com.rosin.manager.common.model.User;

import java.util.List;

public interface CompanyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(List<Company> companies);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated
     */
    int insert(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated
     */
    int insertSelective(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated
     */
    Company selectByPrimaryKey(Integer companyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Company record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Company record);

    List<Company> getAllCompanies();
}