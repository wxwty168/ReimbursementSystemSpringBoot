//package com.jxd.mptest.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//
///**
// * @description:
// * @author: wxwty168
// * @date: 2020/12/24 11:08
// */
//@RestController//所有的请求都是响应数据的请求
//// 这样每个方法之前就不用加@ResponseBody了
//public class VueEmpController {
//
//    @Resource
//    private IEmpService empService;
//
//    @Resource
//    private IStudentService studentService;
//
//    @Autowired
//    private IDeptService deptService;
//
//    @PostMapping("/login")
//    public String login(@RequestBody Users users){
//        if ("admin".equals(users.getName()) && "123".equals(users.getPassword())){
//            return "success";
//        }else {
//            return "fail";
//        }
//    }
//
////    @GetMapping("/getEmps/{limit}/{page}")
////    public Map<String,Object> getEmps(@PathVariable int limit,@PathVariable int page){
////        return empService.selectEmpsWithDept(limit,page);
////    }
//
//    @PostMapping("/getEmps")
//    public Map<String,Object> getEmps(@RequestBody Map<String, String> queryMap){
//        // 获取每个查询参数
//        int limit = Integer.parseInt(queryMap.get("limit"));
//        int page = Integer.parseInt(queryMap.get("page"));
//        String filter = queryMap.get("filter");
//        return empService.selectEmpsWithDept(limit,page,filter);
//    }
////    @PostMapping("/getStudents")
////    public Map<String,Object> getStudents(int page,int limit){
////        System.out.println(page);
////        System.out.println(limit);
////        return null;
////    }
//
//    @GetMapping("/getStudents/{page}/{limit}")
//    public Map<String,Object> getStudents(@PathVariable int page,@PathVariable int limit){
//        System.out.println(page);
//        Map<String,Object> a = studentService.selectAllStudentWithCollegeName(page,limit);
//        return studentService.selectAllStudentWithCollegeName(page,limit);
//    }
//
//    @GetMapping("/getDepts")
//    public List<Dept> getDepts() {
//
//        return deptService.list();
//    }
//
//    @PostMapping("/saveOrUpdateEmp")
//    public String addEmp(@RequestBody Emp emp){
////        emp.setSex(emp.getSex()==null?"男":emp.getSex());
//        if (empService.saveOrUpdate(emp)){
//            return "success";
//        }else {
//            return "fail";
//        }
//    }
//
//    @GetMapping("/getEmpById/{empno}")
//    public Emp getEmpById(@PathVariable int empno){
//        return empService.getById(empno);
//    }
//
//    @PostMapping("/delBatchEmp")
//    public String delBatchEmp(@RequestBody List<Integer> empnos) {
//        if (empService.removeByIds(empnos)){
//            return "success";
//        }else{
//            return "fail";
//        }
//    }
//
//
//}
