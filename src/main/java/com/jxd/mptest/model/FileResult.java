package com.jxd.mptest.model;

import java.io.Serializable;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/28 0:13
 */
public class FileResult implements Serializable {
    //判断结果
    private boolean success;
    //返回信息
    private String message;
    //文件地址
    private String fileAddress;

    private String start;

    public FileResult(boolean success, String message,String fileAddress) {
        this.success = success;
        this.message = message;
        this.fileAddress = fileAddress;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}

