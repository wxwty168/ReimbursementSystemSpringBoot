package com.jxd.mptest.controller;

import com.jxd.mptest.model.Employees;
import com.jxd.mptest.service.ILoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/16 14:15
 */

@RestController
public class LoginController {

    @Resource
    private ILoginService loginService;


    @PostMapping("/login")
    public List<Object> login(@RequestBody Employees employee){
//        System.out.println(employee.getEno()+"_"+employee.getPassword());
        Employees fullEmpInfo = loginService.doLogin(employee);
        List<Object> statusList = new ArrayList<>();

        if (null != fullEmpInfo){
            statusList.add(0);
        }else {
            statusList.add(1);
        }
        statusList.add(fullEmpInfo);
        return statusList;
    }
}
