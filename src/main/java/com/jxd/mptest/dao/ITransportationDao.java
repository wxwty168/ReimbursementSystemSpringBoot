package com.jxd.mptest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.mptest.model.Transportations;

import java.util.List;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/30 16:36
 */
public interface ITransportationDao extends BaseMapper<Transportations> {
    /**
     * 获取所有交通工具列表
     * @return List
     */
    List<Transportations> getAllTransportations();
}
