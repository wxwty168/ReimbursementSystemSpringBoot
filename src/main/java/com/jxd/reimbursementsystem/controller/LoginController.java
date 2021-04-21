package com.jxd.reimbursementsystem.controller;

import com.jxd.reimbursementsystem.model.Employees;
import com.jxd.reimbursementsystem.service.IEmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/16 14:15
 */

@RestController
public class LoginController {

    @Resource
    private IEmployeeService employeeService;


    @PostMapping("/login")
    public List<Object> login(@RequestBody Employees employee){
//        System.out.println(employee.getEno()+"_"+employee.getPassword());
        Map<String, Object> fullEmpInfo = employeeService.doLogin(employee);
        List<Object> statusList = new ArrayList<>();

        if (null != fullEmpInfo){
            statusList.add(0);
        }else {
            statusList.add(1);
        }
        statusList.add(fullEmpInfo);
        return statusList;
    }

    @PostMapping("/changePassword")
    public int changePassword(@RequestBody Map<String, String> pwdForm){
        int eno = Integer.parseInt(pwdForm.get("eno"));
        String password = pwdForm.get("password");
        String newPassword = pwdForm.get("newPassword");
        Employees employee = new Employees(eno,password);
        Map<String, Object> fullEmpInfo = employeeService.doLogin(employee);


        if (null != fullEmpInfo){
            // 原密码正确且修改成功
            if (employeeService.changePassword(eno,newPassword)){
                return 0;
            }else {// 修改失败
                return 1;
            }
        }else {// 原密码不正确
            return 2;
        }
    }
}
