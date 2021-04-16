package com.jxd.mptest.controller;

import com.jxd.mptest.model.District;
import com.jxd.mptest.model.FileResult;
import com.jxd.mptest.model.Tickets;
import com.jxd.mptest.model.Transportations;
import com.jxd.mptest.service.IDistrictService;
import com.jxd.mptest.service.ITicketsService;
import com.jxd.mptest.service.ITransportationService;
import com.jxd.mptest.utils.MyUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/27 14:40
 */
@RestController
public class TicketListController {

    @Resource
    private ITicketsService ticketsService;
    @Resource
    private IDistrictService districtService;
    @Resource
    private ITransportationService transportationService;

    private MyUtils myUtils = new MyUtils();
    private String property = System.getProperty("user.dir");
    private String basePath = property + "/src/main/resources/static/uploadImg";
    private String ticketPhotoPackageName = "ticketImg";
    /**
     * 获取所有车票信息
     * @param queryMap 车票查询条件
     * @return Map
     */
    @PostMapping("/getTickets")
    public Map<String, Object> getTickets(@RequestBody Map<String,String> queryMap){
        // 获取查询参数
        int limit = Integer.parseInt(queryMap.get("limit"));// 每页条数
        int page = Integer.parseInt(queryMap.get("page"));// 当前第几页
        String departure = queryMap.get("departure");
        String destination = queryMap.get("destination");
        int eno = Integer.parseInt(queryMap.get("eno"));
        return ticketsService.selectTicketsByEno(limit,page,departure,destination,eno);
    }

    /**
     * 文件上传
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping("/uploadTicketPic")
    public FileResult uploadTicketPic(@RequestParam("ticketPhoto") MultipartFile picture,@RequestParam("eno") String enoStr, HttpServletRequest request) {

        // 获取当前用户编号

        //获取文件在服务器的储存位置
        String userPath = basePath + "/" + enoStr;
        myUtils.checkDirExist(userPath);
        String ticketsPath = userPath + "/ticketImg";
        myUtils.checkDirExist(ticketsPath);

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        String fileName = myUtils.getUUID() + "_" + name + "." + type;

        //在指定路径下创建一个文件
        File targetFile = new File(ticketsPath, fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            //将文件在服务器的存储路径返回
            return new FileResult(true,fileName,ticketsPath+"/"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new FileResult(false, "上传失败","");
        }
    }

    /**
     * 删除图片
     * @param map 图片url
     * @return String
     */
    @RequestMapping("/delPic")
    public String delPic(@RequestBody Map<String,String> map){
        String eno = map.get("eno");
        String fileName = map.get("picName");
        if (myUtils.deleteFile(eno,ticketPhotoPackageName,fileName)){
            return "success";
        }else{
            return "fail";
        }
    }

    /**
     * 获取所有省份信息
     * @return List
     */
    @RequestMapping("/getAllProvinces")
    public List<District> getAllProvinces(){
        return districtService.getAllProvinces();
    }

    /**
     * 获取所有交通工具信息
     * @return List
     */
    @RequestMapping("/getAllTransportations")
    public List<Transportations> getAllTransportations(){
        return transportationService.getAllTransportations();
    }

    /**
     * 通过选中的省id获取城市列表
     * @param provinceId
     * @return
     */
    @RequestMapping("/getDepartureCities/{provinceId}")
    public List<District> getDepartureCities(@PathVariable int provinceId ){
        return districtService.getDepartureCities(provinceId);
    }
    @RequestMapping("/getArrivalCities/{provinceId}")
    public List<District> getArrivalCities(@PathVariable int provinceId ){
        return districtService.getDepartureCities(provinceId);
    }

    /**
     * 新增或修改车票信息
     * @param ticket
     * @return String
     */
    @RequestMapping("/saveOrUpdateTicket")
    public String saveOrUpdateTicket(@RequestBody Tickets ticket){
        if (ticketsService.saveOrUpdate(ticket)){
            return "success";
        }else {
            return "false";
        }
    }

    /**
     * 批量删除ticket
     * @param ticketIds
     * @return
     */
    @RequestMapping("/delTicketsOnBatch")
    public String delTicketsOnBatch(@RequestBody List<Integer> ticketIds){
        // 获取要删除的车票信息,检查删除存档图片
        Collection<Tickets> ticketsList = ticketsService.listByIds(ticketIds);
        for (Tickets ticket : ticketsList) {
            myUtils.deleteFile(String.valueOf(ticket.getEno()),ticketPhotoPackageName,ticket.getTicketPhotoUrl());
        }
        if (ticketsService.removeByIds(ticketIds)){
            return "success";
        }else{
            return "fail";
        }
    }

    /**
     * 通过id获取ticket的信息
     * @param ticketId
     * @return
     */
    @RequestMapping("/getTicketById/{ticketId}")
    public Map<String, Object> getTicketById(@PathVariable int ticketId){
        // DONE 重新写获取ticket信息的sql语句
        return ticketsService.selectTicketByIdForEdit(ticketId);
//        return ticketsService.getById(ticketId);
    }



}
