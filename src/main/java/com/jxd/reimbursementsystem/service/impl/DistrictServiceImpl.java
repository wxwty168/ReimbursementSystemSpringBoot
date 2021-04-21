package com.jxd.reimbursementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.reimbursementsystem.dao.IDistrictDao;
import com.jxd.reimbursementsystem.model.District;
import com.jxd.reimbursementsystem.service.IDistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/30 16:09
 */
@Service
public class DistrictServiceImpl extends ServiceImpl<IDistrictDao, District>
        implements IDistrictService {

    @Resource
    private IDistrictDao districtDao;

    /**
     * 获取所有省份信息
     *
     * @return List<District>
     */
    @Override
    public List<District> getAllProvinces() {
        return districtDao.getAllProvinces();
    }

    /**
     * 通过省id获取所有市列表
     *
     * @param provinceId
     * @return List
     */
    @Override
    public List<District> getDepartureCities(int provinceId) {
        return districtDao.getDepartureCities(provinceId);
    }
}
