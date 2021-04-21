package com.jxd.reimbursementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.reimbursementsystem.model.Employees;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/16 14:19
 */
public interface IEmployeeService extends IService<Employees> {
    /**
     * 登录
     * @param employee 用户对象
     * @return Map<String, Object>
     */
    Map<String, Object> doLogin(Employees employee);

    /**
     * 修改密码
     * @param eno 员工编号
     * @param password 密码
     * @return boolean
     */
    boolean changePassword(int eno,String password);

    /**
     * 通过员工编号和姓名查找
     * @param page 页码
     * @param limit 每页显示条数
     * @param eno 员工编号
     * @param ename 员工姓名
     * @return Map<String, Object>
     */
    Map<String, Object> selectEmployeesByEnoAndEname(int page,int limit,String eno,String ename,int isDeleted);

    /**
     * 批量删除或恢复员工
     * @param enos 需要更新的员工编号列表
     * @param isDeleted 是否已经被删除
     * @return boolean
     */
    boolean deleteOrUndeleteEmployeesOnBatch(List<Integer> enos,int isDeleted);

    /**
     * 重置密码
     * @param eno 员工编号
     * @return boolean
     */
    boolean resetPassword(int eno);
}
