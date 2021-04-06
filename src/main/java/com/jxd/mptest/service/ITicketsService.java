package com.jxd.mptest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mptest.model.Tickets;

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
}
