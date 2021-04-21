package com.jxd.reimbursementsystem.utils;

import java.io.File;
import java.util.UUID;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/3/29 15:40
 */
public class MyUtils {
    private String property = System.getProperty("user.dir");
    private String basePath = property + "/src/main/resources/static/uploadImg";


    public void checkDirExist(String path){
        File filePath = new File(path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            filePath.mkdir();
        }
    }

    public String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public boolean deleteFile(String eno,String packageName,String fileName) {
        StringBuffer filePath = new StringBuffer(basePath);
        filePath.append("/");
        filePath.append(eno);
        filePath.append("/");
        filePath.append(packageName);
        filePath.append("/");
        filePath.append(fileName);
        File file = new File(filePath.toString());
        // 如果文件路径只有单个文件
        if (file.exists() && file.isFile()) {
            //                System.out.println("删除文件" + fileName + "成功！");
            //                System.out.println("删除文件" + fileName + "失败！");
            return file.delete();
        } else {
//            System.out.println(fileName + "不存在！");
            return false;
        }
    }
}
