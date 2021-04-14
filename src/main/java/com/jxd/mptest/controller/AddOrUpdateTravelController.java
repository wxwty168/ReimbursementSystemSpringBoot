package com.jxd.mptest.controller;

import com.jxd.mptest.model.Tickets;
import com.jxd.mptest.service.ITicketsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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
}
