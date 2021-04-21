package com.jxd.reimbursementsystem.controller;

import com.jxd.reimbursementsystem.model.EmployeeRank;
import com.jxd.reimbursementsystem.model.Employees;
import com.jxd.reimbursementsystem.service.IEmployeeRankService;
import com.jxd.reimbursementsystem.service.IEmployeeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/21 15:30
 */
@RestController
public class ManageEmployeesController {

    @Resource
    private IEmployeeRankService employeeRankService;
    @Resource
    private IEmployeeService employeeService;

    @RequestMapping("/getEmployeeRanks")
    public List<EmployeeRank> getEmployeeRanks(){
        return employeeRankService.list();
    }

    @RequestMapping("/getEmployees")
    public Map<String, Object> getEmployees(@RequestBody Map<String,String> listQuery){
        // 获取查询参数
        int limit = Integer.parseInt(listQuery.get("limit"));// 每页条数
        int page = Integer.parseInt(listQuery.get("page"));// 当前第几页
        String eno = listQuery.get("eno");
        String ename = listQuery.get("ename");
        int isDeleted = Integer.parseInt(listQuery.get("isDeleted"));
        return employeeService.selectEmployeesByEnoAndEname(page,limit,eno,ename,isDeleted);

    }

    @RequestMapping("/deleteOrUndeleteEmployeesOnBatch/{isDeleted}")
    public String deleteOrUndeleteEmployeesOnBatch(@RequestBody List<Integer> enos,
                                                   @PathVariable("isDeleted") int isDeleted){
        if (employeeService.deleteOrUndeleteEmployeesOnBatch(enos,isDeleted)){
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/getEmployeeByEno/{eno}")
    public Employees getEmployeeByEno(@PathVariable("eno") int eno){
        return employeeService.getById(eno);
    }

    @RequestMapping("/saveOrUpdateEmployee")
    public String saveOrUpdateEmployee(@RequestBody Employees employee){
        if (employeeService.saveOrUpdate(employee)){
            return "success";
        }else{
            return "fail";
        }
    }

    @RequestMapping("/resetPassword/{eno}")
    public String resetPassword(@PathVariable("eno") int eno){
        if (employeeService.resetPassword(eno)){
            return "success";
        }else{
            return "fail";
        }
    }
}
