package com.jxd.reimbursementsystem.controller;

import com.jxd.reimbursementsystem.model.FileResult;
import com.jxd.reimbursementsystem.utils.MyUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @description:
 * @author: wxwty168
 * @date: 2021/4/15 20:49
 */
@RestController
public class UtilController {

    private MyUtils myUtils = new MyUtils();
    private String property = System.getProperty("user.dir");
    private String basePath = property + "/src/main/resources/static/uploadImg";
    private String ticketPhotoPackageName = "ticketImg";


    /**
     * 文件上传
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping("/uploadTicketPic")
    public FileResult uploadTicketPic(@RequestParam("ticketPhoto") MultipartFile picture, @RequestParam("eno") String enoStr, HttpServletRequest request) {

        // 获取当前用户编号

        //获取文件在服务器的储存位置
        String userPath = basePath + "/" + enoStr;
        myUtils.checkDirExist(userPath);
        String ticketsPath = userPath + "/ticketImg";
        myUtils.checkDirExist(ticketsPath);

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        String fileName = myUtils.getUUID() + "_" + name + "." + type;

        //在指定路径下创建一个文件
        File targetFile = new File(ticketsPath, fileName);
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            //将文件在服务器的存储路径返回
            return new FileResult(true,fileName,ticketsPath+"/"+fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return new FileResult(false, "上传失败","");
        }
    }

    /**
     * 删除图片
     * @param map 图片url
     * @return String
     */
    @RequestMapping("/delPic")
    public String delPic(@RequestBody Map<String,String> map){
        String eno = map.get("eno");
        String fileName = map.get("picName");
        if (myUtils.deleteFile(eno,ticketPhotoPackageName,fileName)){
            return "success";
        }else{
            return "fail";
        }
    }


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
