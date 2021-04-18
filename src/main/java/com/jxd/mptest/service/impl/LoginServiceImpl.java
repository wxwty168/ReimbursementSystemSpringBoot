package com.jxd.mptest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mptest.dao.IEmployeesDao;
import com.jxd.mptest.model.Employees;
import com.jxd.mptest.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/16 14:36
 */
@Service
public class LoginServiceImpl extends ServiceImpl<IEmployeesDao, Employees>
        implements ILoginService {

    @Resource
    private IEmployeesDao employeesDao;

    @Override
    public Employees doLogin(Employees employee) {
        return employeesDao.doLogin(employee);
    }

    @Override
    public boolean changePassword(int eno, String password) {
        return employeesDao.changePassword(eno,password);
    }
}
