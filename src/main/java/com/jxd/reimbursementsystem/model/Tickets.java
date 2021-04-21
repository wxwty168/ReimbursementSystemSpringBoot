package com.jxd.reimbursementsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/13 16:08
 */
public class Tickets {
    @TableId (value = "ticket_id",type = IdType.AUTO)
    private Integer ticketId;//主键id
    private Integer eno;//员工工号
    private Integer departure;//出发地点
    private Integer destination;//到达地点
    @TableField (value = "departure_time")
    private String departureTime;//出发时间
    @TableField (value = "arrival_time")
    private String arrivalTime;//到达时间
    @TableField (value = "transportation_id")
    private Integer transportationId;//交通工具id
    @TableField (value = "reimbursement_amount")
    private Double reimbursementAmount;//报销总金额
    @TableField (value = "ticket_photo_url")
    private String ticketPhotoUrl;//车票照片url
    @TableField (value = "trip_description")
    private String tripDescription;//出差说明
    @TableField (value = "travel_id")
    private Integer travelId;//差旅信息

    public Tickets() {
    }

    public Tickets(Integer ticketId, Integer eno, Integer departure, Integer destination, String departureTime, String arrivalTime, Integer transportationId, Double reimbursementAmount, String ticketPhotoUrl, String tripDescription, Integer travelId) {
        this.ticketId = ticketId;
        this.eno = eno;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transportationId = transportationId;
        this.reimbursementAmount = reimbursementAmount;
        this.ticketPhotoUrl = ticketPhotoUrl;
        this.tripDescription = tripDescription;
        this.travelId = travelId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(Integer transportationId) {
        this.transportationId = transportationId;
    }

    public Double getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(Double reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public String getTicketPhotoUrl() {
        return ticketPhotoUrl;
    }

    public void setTicketPhotoUrl(String ticketPhotoUrl) {
        this.ticketPhotoUrl = ticketPhotoUrl;
    }

    public String getTripDescription() {
        return tripDescription;
    }

    public void setTripDescription(String tripDescription) {
        this.tripDescription = tripDescription;
    }

    public Integer getTravelId() {
        return travelId;
    }

    public void setTravelId(Integer travelId) {
        this.travelId = travelId;
    }
}
