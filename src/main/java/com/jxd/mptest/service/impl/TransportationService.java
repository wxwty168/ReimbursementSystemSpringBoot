package com.jxd.mptest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.mptest.dao.ITransportationDao;
import com.jxd.mptest.model.Transportations;
import com.jxd.mptest.service.ITransportationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/30 16:42
 */
@Service
public class TransportationService extends ServiceImpl<ITransportationDao, Transportations>
        implements ITransportationService {

    @Resource
    private ITransportationDao transportationDao;

    /**
     * 获取所有交通工具信息
     *
     * @return List
     */
    @Override
    public List<Transportations> getAllTransportations() {
        return transportationDao.getAllTransportations();
    }
}
