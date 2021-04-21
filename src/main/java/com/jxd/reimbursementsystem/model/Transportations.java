package com.jxd.reimbursementsystem.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/13 16:20
 */
public class Transportations {
    @TableId (value = "transportation_id")
    private Integer transportationId;//交通方式ID
    @TableField (value = "transportation_name")
    private String transportationName;//交通工具名称

    public Transportations() {
    }

    public Transportations(Integer transportationId, String transportationName) {
        this.transportationId = transportationId;
        this.transportationName = transportationName;
    }

    public Integer getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(Integer transportationId) {
        this.transportationId = transportationId;
    }

    public String getTransportationName() {
        return transportationName;
    }

    public void setTransportationName(String transportationName) {
        this.transportationName = transportationName;
    }
}
