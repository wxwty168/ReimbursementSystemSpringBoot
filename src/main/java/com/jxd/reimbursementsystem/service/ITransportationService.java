package com.jxd.reimbursementsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxd.reimbursementsystem.model.Transportations;

import java.util.List;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/30 16:41
 */
public interface ITransportationService extends IService<Transportations> {

    /**
     * 获取所有交通工具信息
     * @return List
     */
    List<Transportations> getAllTransportations();
}
