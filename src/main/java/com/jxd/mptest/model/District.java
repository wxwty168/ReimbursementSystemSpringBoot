package com.jxd.mptest.model;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/16 14:10
 */
public class District {
    @TableId
    private Integer areaId;
    private String areaCode;
    private String areaName;
    private Integer level;
    private String cityCode;
    private String center;
    private Integer parentId;

    public District() {
    }

    public District(Integer areaId, String areaCode, String areaName, Integer level, String cityCode, String center, Integer parentId) {
        this.areaId = areaId;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.level = level;
        this.cityCode = cityCode;
        this.center = center;
        this.parentId = parentId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
