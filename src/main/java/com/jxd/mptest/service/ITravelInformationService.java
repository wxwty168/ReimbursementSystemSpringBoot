package com.jxd.mptest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.mptest.model.TravelInformation;

import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/5 18:32
 */
public interface ITravelInformationService extends IService<TravelInformation> {

    /**
     * 通过Eno，起始时间等查询
     * @param limit 每页显示条数
     * @param page 当前页码
     * @param travelId 差旅编号
     * @param timeStart 起始时间
     * @param timeEnd 结束时间
     * @param eno 员工编号
     * @return Map<String, Object>
     */
    Map<String, Object> getTravelsByEnoAndQueries(int limit, int page, String travelId,String timeStart, String timeEnd, int eno);
}
