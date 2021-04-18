package com.jxd.mptest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mptest.model.Employees;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/16 14:35
 */
public interface IEmployeesDao extends BaseMapper<Employees> {
    /**
     * 登录
     * @param employee 用户信息
     * @return Employees
     */
    Employees doLogin(Employees employee);

    boolean changePassword(@Param("eno") int eno,@Param("password") String password);
}
