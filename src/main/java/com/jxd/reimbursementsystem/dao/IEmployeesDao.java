package com.jxd.reimbursementsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.reimbursementsystem.model.Employees;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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
    Map<String, Object> doLogin(Employees employee);

    /**
     * 修改密码
     * @param eno 员工编号
     * @param password 新密码
     * @return boolean
     */
    boolean changePassword(@Param("eno") int eno,@Param("password") String password);

    /**
     * 根据员工编号和员工姓名查找员工
     * @param pages 分页对象
     * @param eno 员工编号
     * @param ename 员工姓名
     * @return Map<String,Object>
     */
    IPage<Map<String,Object>> selectEmployeesByEnoAndEname(Page<Map<String,Object>> pages,
                                                           @Param("eno") String eno,
                                                           @Param("ename") String ename,
                                                           @Param("isDeleted") int isDeleted);

    /**
     * 批量删除或恢复员工
     * @param enos 需要更新的员工编号列表
     * @param setIsDeleted 是否删除新值
     * @return boolean
     */
    boolean updateIsDeletedOnBatch(@Param("enos") List<Integer> enos,
                                   @Param("setIsDeleted") int setIsDeleted);

    /**
     * 重置密码
     * @param eno 员工编号
     * @return boolean
     */
    boolean resetPassword(@Param("eno") int eno);
}
