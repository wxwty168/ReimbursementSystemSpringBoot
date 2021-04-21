package com.jxd.reimbursementsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.reimbursementsystem.dao.IEmployeesDao;
import com.jxd.reimbursementsystem.model.Employees;
import com.jxd.reimbursementsystem.service.IEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/16 14:36
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<IEmployeesDao, Employees>
        implements IEmployeeService {

    @Resource
    private IEmployeesDao employeesDao;

    @Override
    public Map<String, Object> doLogin(Employees employee) {
        return employeesDao.doLogin(employee);
    }

    @Override
    public boolean changePassword(int eno, String password) {
        return employeesDao.changePassword(eno,password);
    }

    /**
     * 通过员工编号和姓名查找
     *
     * @param page  页码
     * @param limit 每页显示条数
     * @param eno   员工编号
     * @param ename 员工姓名
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> selectEmployeesByEnoAndEname(int page, int limit, String eno, String ename,int isDeleted) {
        Page<Map<String, Object>> pages = new Page<>(page,limit);
        Map<String, Object> map = new HashMap<>();
        IPage<Map<String, Object>> result = employeesDao.selectEmployeesByEnoAndEname(pages,eno,ename,isDeleted);
        map.put("employeeList",result.getRecords());
        map.put("total",result.getTotal());// 总条数
        map.put("pageCount",result.getPages());
        return map;
    }

    /**
     * 批量删除或恢复员工
     *
     * @param enos      需要更新的员工编号列表
     * @param isDeleted 是否已经被删除
     * @return boolean
     */
    @Override
    public boolean deleteOrUndeleteEmployeesOnBatch(List<Integer> enos, int isDeleted) {
        if (isDeleted == 0){
            return employeesDao.updateIsDeletedOnBatch(enos,1);
        }else {
            return employeesDao.updateIsDeletedOnBatch(enos,0);
        }
    }

    /**
     * 重置密码
     *
     * @param eno 员工编号
     * @return boolean
     */
    @Override
    public boolean resetPassword(int eno) {
        return employeesDao.resetPassword(eno);
    }
}
