package com.jxd.reimbursementsystem.controller;

import com.jxd.reimbursementsystem.model.District;
import com.jxd.reimbursementsystem.model.FileResult;
import com.jxd.reimbursementsystem.model.Tickets;
import com.jxd.reimbursementsystem.model.Transportations;
import com.jxd.reimbursementsystem.service.IDistrictService;
import com.jxd.reimbursementsystem.service.ITicketsService;
import com.jxd.reimbursementsystem.service.ITransportationService;
import com.jxd.reimbursementsystem.utils.MyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
