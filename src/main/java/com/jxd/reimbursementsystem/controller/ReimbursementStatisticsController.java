package com.jxd.reimbursementsystem.controller;

import com.jxd.reimbursementsystem.service.ITravelInformationService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/5/18 15:58
 */
@RestController
public class ReimbursementStatisticsController {

    @Resource
    private ITravelInformationService travelInformationService;

    @RequestMapping("/getStatisticsList")
    public Map<String,Object> getTravelsToReview(@RequestBody Map<String,String> queryMap ){
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String ename = queryMap.get("ename");
        String timeStart = queryMap.get("timeStart");
        String timeEnd = queryMap.get("timeEnd");
        return travelInformationService.getReimbursementStatistics(limit,page,ename,timeStart,timeEnd);
    }

}
