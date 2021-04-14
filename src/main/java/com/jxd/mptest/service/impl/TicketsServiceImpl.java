package com.jxd.mptest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mptest.dao.ITicketsDao;
import com.jxd.mptest.model.Tickets;
import com.jxd.mptest.service.ITicketsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/27 14:55
 */
@Service
public class TicketsServiceImpl extends ServiceImpl<ITicketsDao, Tickets>
        implements ITicketsService {

    @Resource
    private ITicketsDao ticketsDao;
    /**
     * 通过eno筛选车票
     *
     * @param limit       每页显示条数
     * @param page        当前页码
     * @param departure   出发地点
     * @param destination 目的地点
     * @param eno         员工编号
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> selectTicketsByEno(int limit, int page, String departure, String destination, int eno) {
        // 构造MyBatis-Plus的分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);

        Map<String,Object> map = new HashMap<>();
        // 调用dao层获取数据
        IPage<Map<String,Object>> result = ticketsDao.selectTicketsByEno(pages,departure,destination,eno);
        map.put("tickets",result.getRecords());
        map.put("total",result.getTotal());// 总条数
        map.put("pageCount",result.getPages());

        return map;
    }

    /**
     * 通过id获取车票信息(编辑页面)
     *
     * @param ticketId
     * @return Map
     */
    @Override
    public Map<String, Object> selectTicketByIdForEdit(int ticketId) {
        return ticketsDao.selectTicketByIdForEdit(ticketId);
    }

    /**
     * 获取报销人当前报销单下可选的车票列表
     *
     * @param eno           报销人工号
     * @param travelId      报销单号
     * @param chosenTickets 已选的车票列表
     * @return List<Map < String, Object>>
     */
    @Override
    public List<Map<String, Object>> selectAvailableTicketsByEnoAndTravelId(int eno, String travelId, List<Integer> chosenTickets) {
        return ticketsDao.selectAvailableTicketsByEnoAndTravelId(eno, travelId, chosenTickets);
    }

}
