package com.doulin.common.qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 解析二维码
 * @author 马凌冰
 */
public class ReadQRCodeUitl {

    public static String readQcode(String pathname) throws IOException {
      // String pathname="D:/dd.png";
        //图片路径
        File file=new File(pathname);
        //读取图片到缓冲区
        BufferedImage bufferedImage= ImageIO.read(file);
        //解码器
        QRCodeDecoder codeDecoder=new QRCodeDecoder();
        /**
         *codeDecoder.decode(new MyQRCodeImage())
         *这里需要实现QRCodeImage接口，移步最后一段代码
         */
        //通过解析二维码获得信息
        String result=new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)),"UTF-8");
        //System.out.println(result);
        return result;
    }
//    public static void main(String[] args) throws IOException {
//        System.out.println(readQcode("D:/dd.png"));
//    }

}
