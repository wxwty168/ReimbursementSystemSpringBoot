package com.jxd.mptest.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mptest.dao.ITravelInformationDao;
import com.jxd.mptest.model.TravelInformation;
import com.jxd.mptest.service.ITravelInformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/5 18:32
 */
@Service
public class TravelInformationServiceImpl extends ServiceImpl<ITravelInformationDao, TravelInformation>
        implements ITravelInformationService {

    @Resource
    private ITravelInformationDao travelInformationDao;
    /**
     * 通过Eno，起始时间等查询
     *
     * @param limit     每页显示条数
     * @param page      当前页码
     * @param travelId  差旅编号
     * @param timeStart 起始时间
     * @param timeEnd   结束时间
     * @param eno       员工编号
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> getTravelsByEnoAndQueries(int limit, int page, String travelId, String timeStart, String timeEnd, int eno,String passed) {
        // 构造MyBatis-Plus的分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);

        Map<String,Object> map = new HashMap<>();
        // 调用dao层获取数据
        IPage<TravelInformation> result = travelInformationDao.getTravelsByEnoAndQueries(pages,travelId,timeStart,timeEnd,eno,passed);
        map.put("travels",result.getRecords());
        map.put("total",result.getTotal());// 总条数
        map.put("pageCount",result.getPages());

        return map;
    }

    /**
     * 为差旅审核页面获取数据
     *
     * @param limit     每页显示条数
     * @param page      当前页码
     * @param travelId  差旅编号
     * @param ename     员工姓名
     * @param timeStart 起始时间
     * @param timeEnd   结束时间
     * @param passed    是否通过审核
     * @return Map<String, Object>
     */
    @Override
    public Map<String, Object> getTravelsToReview(int limit, int page, String travelId, String ename, String timeStart, String timeEnd, int passed) {
        // 构造MyBatis-Plus的分页对象
        Page<Map<String,Object>> pages = new Page<>(page,limit);

        Map<String,Object> map = new HashMap<>();
        // 调用dao层获取数据
        IPage<Map<String, Object>> result = travelInformationDao.getTravelsToReview(pages,travelId,ename,timeStart,timeEnd,passed);
        map.put("travels",result.getRecords());
        map.put("total",result.getTotal());// 总条数
        map.put("pageCount",result.getPages());

        return map;
    }

    /**
     * 审核旅程,修改passed信息
     *
     * @param travelId 旅程id
     * @param passed   是否通过
     * @return boolean
     */
    @Override
    public Boolean submitReviewTravel(int travelId, int passed) {
        return travelInformationDao.submitReviewTravel(travelId,passed);
    }
}
