package com.jxd.mptest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.mptest.model.TravelInformation;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/5 18:31
 */
public interface ITravelInformationDao extends BaseMapper<TravelInformation> {

    /**
     * 通过Eno，起始时间等查询
     * @param pages mybatis-plus分页对象
     * @param travelId 差旅编号
     * @param timeStart 起始时间
     * @param timeEnd 结束时间
     * @param eno 员工编号
     * @return Map<String, Object>
     */
    IPage<TravelInformation> getTravelsByEnoAndQueries(Page<Map<String,Object>> pages,
                                                        @Param("travelId") String travelId,
                                                        @Param("timeStart") String timeStart,
                                                        @Param("timeEnd") String timeEnd,
                                                        @Param("eno") int eno);

}