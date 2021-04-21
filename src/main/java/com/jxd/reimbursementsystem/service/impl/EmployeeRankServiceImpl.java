package com.jxd.reimbursementsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.reimbursementsystem.dao.IEmployeeRankDao;
import com.jxd.reimbursementsystem.model.EmployeeRank;
import com.jxd.reimbursementsystem.service.IEmployeeRankService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/21 15:34
 */
@Service
public class EmployeeRankServiceImpl extends ServiceImpl<IEmployeeRankDao, EmployeeRank>
        implements IEmployeeRankService {
}
