package com.jxd.reimbursementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.reimbursementsystem.model.Tickets;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/27 14:50
 */
public interface ITicketsService extends IService<Tickets> {

    /**
     * 通过eno筛选车票
     * @param limit 每页显示条数
     * @param page 当前页码
     * @param departure 出发地点
     * @param destination 目的地点
     * @param eno 员工编号
     * @return Map<String, Object>
     */
    Map<String, Object> selectTicketsByEno(int limit, int page, String departure, String destination, int eno);

    /**
     * 通过id获取车票信息(编辑页面)
     * @param ticketId
     * @return Map
     */
    Map<String,Object> selectTicketByIdForEdit(int ticketId);

    /**
     * 获取报销人当前报销单下可选的车票列表
     * @param eno 报销人工号
     * @param travelId 报销单号
     * @param chosenTickets 已选的车票列表
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectAvailableTicketsByEnoAndTravelId(int eno, String travelId, List<Integer> chosenTickets);

    /**
     * 取消所有车票对该差旅Id的绑定
     * @param travelId 需要取消绑定的差旅id
     * @return Boolean
     */
    Boolean unBindTicketsFromTravel(int travelId);

    /**
     * 将车票绑定到差旅上
     * @param travelId 差旅Id
     * @param ticketList 车票列表
     * @return Boolean
     */
    Boolean bindTicketsToTravel(int travelId, List<Integer> ticketList);

    /**
     * 通过绑定的travelId获取车票列表
     * @param travelId 差旅Id
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getTicketsListByTravelId(int travelId);
}
