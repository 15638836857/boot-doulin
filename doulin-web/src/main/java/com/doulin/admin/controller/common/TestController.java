package com.doulin.admin.controller.common;

import com.doulin.entity.image.ImgDoConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @className TestController
 * @Description TODO
 * @Autor 马凌冰
 * @Date 2021/5/8 10:28
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private ImgDoConfig imgDoConfig;
    @RequestMapping("")
    public String getTest(){
        return "qrcode1";
    }
    @GetMapping(value = "img")
    @ResponseBody
    public  String getImage(HttpServletResponse response) throws IOException {
        JEditorPane ed = new JEditorPane(new URL("https://www.cnblogs.com/liuyangfirst/p/13070817.html"));
        ed.setSize(2000,2000);

        //create a new image
        BufferedImage image = new BufferedImage(ed.getWidth(), ed.getHeight(),   BufferedImage.TYPE_INT_ARGB);

        //paint the editor onto the image
        SwingUtilities.paintComponent(image.createGraphics(),
                ed,
                new JPanel(),
                0, 0, image.getWidth(), image.getHeight());
        //save the image to file
        ImageIO.write((RenderedImage)image, "png", new File(imgDoConfig.getFilePath()+"html.png"));
        return "http://localhost:8090/"+imgDoConfig.getPrefix()+"html.png";
    }
}
