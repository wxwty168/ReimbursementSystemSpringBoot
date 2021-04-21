package com.jxd.reimbursementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.reimbursementsystem.model.Employees;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/16 14:19
 */
public interface ILoginService extends IService<Employees> {
    Employees doLogin(Employees employee);
    boolean changePassword(int eno,String password);
}
