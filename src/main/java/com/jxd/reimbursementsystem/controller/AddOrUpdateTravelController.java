package com.jxd.reimbursementsystem.controller;

import com.jxd.reimbursementsystem.model.TravelInformation;
import com.jxd.reimbursementsystem.service.ITicketsService;
import com.jxd.reimbursementsystem.service.ITravelInformationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/14 19:16
 */
@RestController
public class AddOrUpdateTravelController {

    @Resource
    private ITicketsService ticketsService;
    @Resource
    private ITravelInformationService travelInformationService;

    private List<Integer> objectsToIntegerList(Object obj){
        List<Integer> theList = new ArrayList<>();
        // obj 转list
        if (obj instanceof ArrayList<?>) {
            for (Object o : (List<?>) obj) {
                theList.add((Integer) o);
            }
        }
        return theList;
    }

    @RequestMapping("/getAvailableTickets")
    public List<Map<String,Object>> getAvailableTickets(@RequestBody Map<String, Object> listQuery){
//    public List<Map<String,Object>> getAvailableTickets(@RequestParam("eno") int eno,
//                                                  @RequestParam("travelId") String travelId,
//                                                  @RequestParam("chosenTickets") List<Integer> chosenTickets){
        int eno = Integer.parseInt(listQuery.get("eno").toString());
        String travelId = listQuery.get("travelId").toString();
        List<Integer> chosenTickets = new ArrayList<>();
        Object obj = listQuery.get("chosenTickets");
        // obj 转list
        if (obj instanceof ArrayList<?>) {
            for (Object o : (List<?>) obj) {
                chosenTickets.add((Integer) o);
            }
        }
        return ticketsService.selectAvailableTicketsByEnoAndTravelId(eno, travelId, chosenTickets);
    }

    @RequestMapping("/saveOrUpdateTravel")
    public String saveOrUpdateTravel(@RequestBody Map<String, Object> form){
        // 创建travel对象并赋值
        TravelInformation travel = new TravelInformation();
        // 更新操作:即travelId非空时
        if (null != form.get("travelId").toString() && !"".equals(form.get("travelId").toString())){
            travel.setTravelId(Integer.parseInt(form.get("travelId").toString()));
        }
        travel.setEno(Integer.parseInt(form.get("eno").toString()));
        travel.setFirstDepartureTime(form.get("firstDepartureTime").toString());
        travel.setLastArrivalTime(form.get("lastArrivalTime").toString());
        travel.setDaysOfTravel(Double.parseDouble(form.get("daysOfTravel").toString()));
        travel.setSubsidyAmount(Double.parseDouble(form.get("subsidyAmount").toString()));
        travel.setTotalReimbursement(Double.parseDouble(form.get("totalReimbursement").toString()));
        travel.setTravelDescription(form.get("travelDescription").toString());
        travel.setSubmitTime(form.get("submitTime").toString());
        // 如果是更新未通过的车票列表需要将其设置为待审核
        travel.setPassed(0);

        // 获取需要更新的车票Id
        List<Integer> selectedTickets = objectsToIntegerList(form.get("selectedTickets"));
        // 更新或新建travel
        if (travelInformationService.saveOrUpdate(travel)){
            // 获取需要操作的travelId
            int travelId = travel.getTravelId();
            // 取消所有车票对该差旅Id的绑定
            // 将选中车票绑定到该差旅行程上
            ticketsService.unBindTicketsFromTravel(travelId);
            if (ticketsService.bindTicketsToTravel(travelId,selectedTickets)){
                return "success";
            }
        }
        return "fail";
    }

    /**
     * 编辑行程页面查询信息接口
     * @param travelId
     * @return
     */
    @RequestMapping("/getTravelByTravelId/{travelId}")
    public Map<String,Object> getTravelByTravelId(@PathVariable("travelId") int travelId){
        Map<String,Object> travel = travelInformationService.getTravelByTravelId(travelId);
        List<Map<String,Object>> chosenTickets = ticketsService.getTicketsListByTravelId(travelId);
        Map<String, Object> map = new HashMap<>();
        map.put("travelInfo",travel);
        map.put("ticketList",chosenTickets);
        return map;
    }

}
