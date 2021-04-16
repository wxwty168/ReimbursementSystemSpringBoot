package com.jxd.mptest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.mptest.model.Tickets;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/27 14:57
 */
public interface ITicketsDao extends BaseMapper<Tickets> {
    /**
     * 通过员工编号获取车票信息
     * @param pages
     * @param departure
     * @param destination
     * @param eno
     * @return Map
     */
    IPage<Map<String,Object>> selectTicketsByEno(Page<Map<String,Object>> pages,
                                                 @Param("departure") String departure,
                                                 @Param("destination") String destination,
                                                 @Param("eno") int eno);

    /**
     * 通过id获取车票信息(编辑页面)
     * @param ticketId
     * @return Map
     */
    Map<String,Object> selectTicketByIdForEdit(@Param("ticketId") int ticketId);

    /**
     * 获取报销人当前报销单下可选的车票列表
     * @param eno 报销人工号
     * @param travelId 报销单号
     * @param chosenTickets 已选的车票列表
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectAvailableTicketsByEnoAndTravelId(@Param("eno") int eno,
                                                                     @Param("travelId") String travelId,
                                                                     @Param("chosenTickets") List<Integer> chosenTickets);

    /**
     * 取消所有车票对该差旅Id的绑定
     * @param travelId 需要取消绑定的差旅id
     * @return Boolean
     */
    Boolean unBindTicketsFromTravel(@Param("travelId") int travelId);

    /**
     * 将车票绑定到差旅上
     * @param TravelId 差旅Id
     * @param ticketList 车票列表
     */
    Boolean bindTicketsToTravel(@Param("travelId") int TravelId,
                                @Param("ticketList") List<Integer> ticketList);

    /**
     * 通过绑定的travelId获取车票列表
     * @param travelId 差旅Id
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getTicketsListByTravelId(int travelId);
}
