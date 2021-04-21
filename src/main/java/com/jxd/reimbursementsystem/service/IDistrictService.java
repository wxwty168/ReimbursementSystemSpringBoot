package com.jxd.reimbursementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.reimbursementsystem.model.District;

import java.util.List;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/30 16:08
 */
public interface IDistrictService extends IService<District> {

    /**
     * 获取所有省份信息
     * @return List<District>
     */
    List<District> getAllProvinces();

    /**
     * 通过省id获取所有市列表
     * @param provinceId
     * @return List
     */
    List<District> getDepartureCities(int provinceId);
}
