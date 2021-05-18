package com.jxd.reimbursementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.reimbursementsystem.model.TravelInformation;

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
    Map<String, Object> getTravelsByEnoAndQueries(int limit, int page, String travelId,String timeStart, String timeEnd, int eno,String passed);

    /**
     * 为差旅审核页面获取数据
     * @param limit 每页显示条数
     * @param page 当前页码
     * @param travelId 差旅编号
     * @param ename 员工姓名
     * @param timeStart 起始时间
     * @param timeEnd 结束时间
     * @param passed 是否通过审核
     * @return Map<String, Object>
     */
    Map<String, Object> getTravelsToReview(int limit, int page, String travelId, String ename, String timeStart, String timeEnd, int passed);

    /**
     * 审核旅程,修改passed信息
     * @param travelId 旅程id
     * @param passed 是否通过
     * @return boolean
     */
    Boolean submitReviewTravel(int travelId,int passed);

    /**
     * 通过Id获取差旅信息
     * @param travelId Id
     * @return Map<String, Object>
     */
    Map<String, Object> getTravelByTravelId(int travelId);

    /**
     * 获取报销的统计数据
     * @param limit 每页多少数据
     * @param page 当前第几页
     * @param ename 员工姓名
     * @param timeStart 开始日期
     * @param timeEnd 结束日期
     * @return Map<String, Object>
     */
    Map<String, Object> getReimbursementStatistics(int limit, int page, String ename, String timeStart, String timeEnd);

}
