package com.jxd.mptest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mptest.model.District;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/30 16:09
 */
public interface IDistrictDao extends BaseMapper<District> {
    /**
     * 获取所有省份信息列表
     * @return List
     */
    List<District> getAllProvinces();

    /**
     * 通过省id获取所有市列表
     * @param provinceId
     * @return List
     */
    List<District> getDepartureCities(@Param("provinceId") int provinceId);
}
