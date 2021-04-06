package com.jxd.mptest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.mptest.model.Tickets;
import org.apache.ibatis.annotations.Param;

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
}
