package com.jxd.reimbursementsystem.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/13 14:57
 */
public class Employees {
    @TableId(type = IdType.AUTO)
    private Integer eno;//工号
    private String ename;//姓名
    private String password;//密码
    private Integer sex;//性别
    private String phone;//电话
    @TableField (value = "is_admin")
    private Integer isAdmin;//是否管理员
    @TableField (value = "avatar_url")
    private String avatarUrl;
    @TableField (value = "is_deleted")
    private Integer isDeleted;// 是否删除员工
    private Integer rank;// 员工职级

    public Employees() {
    }

    public Employees(Integer eno, String password) {
        this.eno = eno;
        this.password = password;
    }

    public Employees(Integer eno, String ename, String password, Integer sex, String phone, Integer isAdmin, String avatarUrl, Integer isDeleted, Integer rank) {
        this.eno = eno;
        this.ename = ename;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.isAdmin = isAdmin;
        this.avatarUrl = avatarUrl;
        this.isDeleted = isDeleted;
        this.rank = rank;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "eno=" + eno +
                ", ename='" + ename + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", isAdmin=" + isAdmin +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}

