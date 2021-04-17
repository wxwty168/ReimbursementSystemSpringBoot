package com.jxd.mptest.controller;

import com.jxd.mptest.service.ITravelInformationService;
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
 * @date: 2021/4/17 16:46
 */
@RestController
public class ReviewTravelsController {

    @Resource
    private ITravelInformationService travelInformationService;

    @RequestMapping("/getTravelsToReview")
    public Map<String,Object> getTravelsToReview(@RequestBody Map<String,String> queryMap ){
        int limit = Integer.parseInt(queryMap.get("limit"));
        int page = Integer.parseInt(queryMap.get("page"));
        String ename = queryMap.get("ename");
        String travelId = queryMap.get("travelId");
        String timeStart = queryMap.get("timeStart");
        String timeEnd = queryMap.get("timeEnd");
        int passed = Integer.parseInt(queryMap.get("passed"));
        return travelInformationService.getTravelsToReview(limit,page,travelId,ename,timeStart,timeEnd,passed);
    }

    @RequestMapping("/submitReviewTravel/{travelId}/{passed}")
    public String submitReviewTravel(@PathVariable("travelId") int travelId,@PathVariable("passed") int passed){
        if (travelInformationService.submitReviewTravel(travelId,passed)){
            return "success";
        }else{
            return "fail";
        }
    }
}
