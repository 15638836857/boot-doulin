package com.doulin.admin.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @className ALiYunOSSController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/4/15 19:43
 * @Version 1.0
 */
    @Controller
    @RequestMapping("/aly/aliyun")
    public class ALiYunOSSController {

    @RequestMapping(value = "/headImgUpload", method = RequestMethod.POST)
    @ResponseBody
    public String headImgUpload(HttpServletRequest request, MultipartFile file) throws Exception {
        String head = updateHead(file);
        return head;
    }

    public String updateHead(MultipartFile file) throws Exception {
        if (file == null || file.getSize() <= 0) {
            throw new Exception("头像不能为空");
        }
        String nameHz = file.getOriginalFilename(); //上传的文件名 + 后缀    如  asd.png
        String type = "";
        if (nameHz.contains(".png") || nameHz.contains(".jpg")) {
            type = "/img";
        }
        if (nameHz.contains(".mp4") || nameHz.contains(".ogv")) {
            type = "/video";
        } else {
            type = "/file";
        }
//       OSS ossClient = new OSSClient();
//        String keyName = ossClient.uploadImg2Oss(file, type);
//        String imgUrl = ossClient.getImgUrl(keyName);

//        return imgUrl;
        return null;
    }



}
