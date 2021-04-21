package com.jxd.reimbursementsystem.controller;

import com.jxd.reimbursementsystem.service.ITicketsService;
import com.jxd.reimbursementsystem.service.ITravelInformationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/5 18:58
 */
@RestController
public class TravelListController {
    @Resource
    private ITravelInformationService travelInformationService;

    @Resource
    private ITicketsService ticketsService;

    @RequestMapping("/getTravels")
    public Map<String, Object> getTravels(@RequestBody Map<String, String> queryMap){
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        int eno = Integer.parseInt(queryMap.get("eno"));
        String travelId = queryMap.get("travelId");
        String timeStart = queryMap.get("timeStart");
        String timeEnd = queryMap.get("timeEnd");
        String passed = queryMap.get("passed");
        return travelInformationService.getTravelsByEnoAndQueries(limit,page,travelId,timeStart,timeEnd,eno,passed);
    }

    @RequestMapping("/delTravelsOnBatch")
    public String delTravelsOnBatch(@RequestBody List<Integer> travelIds){
        if (travelInformationService.removeByIds(travelIds)){
            for(int travelId : travelIds){
                ticketsService.unBindTicketsFromTravel(travelId);
            }
            return "success";
        }else {
            return "fail";
        }
    }
}
