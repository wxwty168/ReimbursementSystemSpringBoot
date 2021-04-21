package com.jxd.reimbursementsystem.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/21 14:22
 */
@TableName (value = "employee_rank")
public class EmployeeRank {
    @TableId
    private Integer rank;
    private String title;
    @TableField(value = "daily_allowance")
    private Integer dailyAllowance;

    public EmployeeRank() {
    }

    public EmployeeRank(Integer rank, String title, Integer dailyAllowance) {
        this.rank = rank;
        this.title = title;
        this.dailyAllowance = dailyAllowance;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDailyAllowance() {
        return dailyAllowance;
    }

    public void setDailyAllowance(Integer dailyAllowance) {
        this.dailyAllowance = dailyAllowance;
    }
}
