package com.rosin.manager.model;

public class Company {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.company_id
     *
     * @mbg.generated
     */
    private Integer companyId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.company_name
     *
     * @mbg.generated
     */
    private String companyName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column company.company_leaderId
     *
     * @mbg.generated
     */
    private Integer companyLeaderid;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table company
     *
     * @mbg.generated
     */
    public Company(Integer companyId, String companyName, Integer companyLeaderid) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyLeaderid = companyLeaderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.company_id
     *
     * @return the value of company.company_id
     *
     * @mbg.generated
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.company_name
     *
     * @return the value of company.company_name
     *
     * @mbg.generated
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column company.company_leaderId
     *
     * @return the value of company.company_leaderId
     *
     * @mbg.generated
     */
    public Integer getCompanyLeaderid() {
        return companyLeaderid;
    }
}