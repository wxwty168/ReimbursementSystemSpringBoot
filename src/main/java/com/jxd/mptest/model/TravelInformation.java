package com.jxd.mptest.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/13 16:19
 */
@TableName (value = "travel_information")
public class TravelInformation {
    @TableId (value = "travel_id",type = IdType.AUTO)
    private Integer travelId;//主键id
    private Integer eno;//报销人的工号
    @TableField (value = "first_departure_time")
    private String firstDepartureTime;//差旅出发的时间
    @TableField (value = "last_arrival_time")
    private String lastArrivalTime;//差旅结束的时间
    @TableField (value = "days_of_travel")
    private Double daysOfTravel;//出差天数
    @TableField (value = "travel_description")
    private String travelDescription;//出差说明
    @TableField (value = "submit_time")
    private String submitTime;//报销时间
    @TableField (value = "subsidy_amount")
    private Double subsidyAmount;//补助金额
    @TableField (value = "total_reimbursement")
    private Double totalReimbursement;//报销总额
    private Integer passed;

    public TravelInformation() {
    }

    public TravelInformation(Integer travelId, Integer eno, String firstDepartureTime, String lastArrivalTime, Double daysOfTravel, String travelDescription, String submitTime, Double subsidyAmount, Double totalReimbursement, Integer passed) {
        this.travelId = travelId;
        this.eno = eno;
        this.firstDepartureTime = firstDepartureTime;
        this.lastArrivalTime = lastArrivalTime;
        this.daysOfTravel = daysOfTravel;
        this.travelDescription = travelDescription;
        this.submitTime = submitTime;
        this.subsidyAmount = subsidyAmount;
        this.totalReimbursement = totalReimbursement;
        this.passed = passed;
    }

    public Integer getPassed() {
        return passed;
    }

    public void setPassed(Integer passed) {
        this.passed = passed;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getFirstDepartureTime() {
        return firstDepartureTime;
    }

    public void setFirstDepartureTime(String firstDepartureTime) {
        this.firstDepartureTime = firstDepartureTime;
    }

    public String getLastArrivalTime() {
        return lastArrivalTime;
    }

    public void setLastArrivalTime(String lastArrivalTime) {
        this.lastArrivalTime = lastArrivalTime;
    }

    public Double getDaysOfTravel() {
        return daysOfTravel;
    }

    public void setDaysOfTravel(Double daysOfTravel) {
        this.daysOfTravel = daysOfTravel;
    }

    public String getTravelDescription() {
        return travelDescription;
    }

    public void setTravelDescription(String travelDescription) {
        this.travelDescription = travelDescription;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public Double getSubsidyAmount() {
        return subsidyAmount;
    }

    public void setSubsidyAmount(Double subsidyAmount) {
        this.subsidyAmount = subsidyAmount;
    }

    public Double getTotalReimbursement() {
        return totalReimbursement;
    }

    public void setTotalReimbursement(Double totalReimbursement) {
        this.totalReimbursement = totalReimbursement;
    }
}
