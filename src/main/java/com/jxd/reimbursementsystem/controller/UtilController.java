package com.jxd.reimbursementsystem.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/15 20:49
 */
@RestController
public class UtilController {

    private String property = System.getProperty("user.dir");
    private String basePath = property + "/src/main/resources/static/uploadImg";
    private String ticketPhotoPackageName = "ticketImg";

    //下载文件
    @RequestMapping("/downloadPicture/{eno}/{packageName}/{name}")
    public ResponseEntity<byte[]> downLoad(@PathVariable("eno") String eno,
                                           @PathVariable("packageName") String packageName,
                                           @PathVariable("name") String name,
                                           HttpServletRequest request){
        String fName = "/" + eno+ "/" + packageName + "/" + name;
        //定义返回对象
        ResponseEntity<byte[]> responseEntity = null;

        //获取文件的全路径
        String savePath = basePath + fName;
        //创建文件对象
        File file = new File(savePath);
        //定义输入流
        try {
            InputStream in = new FileInputStream(file);
            //创建缓冲区
            byte[] bytes = new byte[in.available()];
            //开始读取,读取到bytes数组中
            in.read(bytes);

            //设置响应头
            HttpHeaders header = new HttpHeaders();

            //去掉UUID前缀
            fName = fName.substring(fName.indexOf("_")+1);
            //设置文件名的字符集编码
            String fName_new = new String(fName.getBytes("gbk"), StandardCharsets.ISO_8859_1);
            //添加响应头：设置类型为attachment附件，设置下载文件名为fName_new
            header.add("Content-Disposition","attachment;filename="+fName_new);
            //设置响应状态
            HttpStatus status = HttpStatus.OK;

            //将响应内容，响应头以及响应状态全部封装到ResponseEntity对象中
            responseEntity = new ResponseEntity<byte[]>(bytes,header,status);
            //关闭输入流
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseEntity;
    }

}
