package com.jxd.mptest.controller;

import com.jxd.mptest.service.ITravelInformationService;
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

    @RequestMapping("/getTravels")
    public Map<String, Object> getTravels(@RequestBody Map<String, String> queryMap){
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        int eno = Integer.parseInt(queryMap.get("eno"));
        String travelId = queryMap.get("travelId");
        String timeStart = queryMap.get("timeStart");
        String timeEnd = queryMap.get("timeEnd");
        return travelInformationService.getTravelsByEnoAndQueries(limit,page,travelId,timeStart,timeEnd,eno);
    }

    @RequestMapping("/delTravelsOnBatch")
    public String delTravelsOnBatch(@RequestBody List<Integer> travelIds){
        if (travelInformationService.removeByIds(travelIds)){
            return "success";
        }else {
            return "fail";
        }
    }
}
