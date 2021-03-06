package com.doulin.common.qrcode;
import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * 制作二维码（日本）
 * @author 马凌冰
 */
public class MakeQRCodeUtil {
    public static void encodeQRCode(String content,String imgpath,String imgType,int size) throws IOException {
        BufferedImage bufferedImage=qRCodeCommon(content,imgType,size);
        File file=new File(imgpath);
       //生成二维码图片
        ImageIO.write(bufferedImage,imgType,file);
    }

    /**
     *
     * @param content 存放内容
     * @param imgType 图片类型 png、jpg 等
     * @param size 长、宽
     * @return
     */
    public static BufferedImage qRCodeCommon(String content,String imgType,int size) throws IOException {
        //计算二维码图片的高宽比
        // API文档规定计算图片宽高的方式 ，v是本次测试的版本号
        int v =size;
        int width = 67 + 12 * (v - 1);
        int height = 67 + 12 * (v - 1);


        Qrcode x = new Qrcode();
        /**
         * 纠错等级分为
         * level L : 最大 7% 的错误能够被纠正；
         * level M : 最大 15% 的错误能够被纠正；
         * level Q : 最大 25% 的错误能够被纠正；
         * level H : 最大 30% 的错误能够被纠正；
         */
        x.setQrcodeErrorCorrect('L');
        x.setQrcodeEncodeMode('B');//注意版本信息 N代表数字 、A代表 a-z,A-Z、B代表 其他)
        x.setQrcodeVersion(v);//版本号  1-40
        String qrData = content;//内容信息

        byte[] d = qrData.getBytes("utf-8");//汉字转格式需要抛出异常

        //缓冲区
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        //绘图
        Graphics2D gs = bufferedImage.createGraphics();

        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0, 0, width, height);//初始化

        //偏移量
        int pixoff = 2;


        /**
         * 容易踩坑的地方
         * 1.注意for循环里面的i，j的顺序，
         *   s[j][i]二维数组的j，i的顺序要与这个方法中的 gs.fillRect(j*3+pixoff,i*3+pixoff, 3, 3);
         *   顺序匹配，否则会出现解析图片是一串数字
         * 2.注意此判断if (d.length > 0 && d.length < 120)
         *   是否会引起字符串长度大于120导致生成代码不执行，二维码空白
         *   根据自己的字符串大小来设置此配置
         */
        //if (d.length > 0 && d.length < 120) {
            boolean[][] s = x.calQrcode(d);

            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                    }
                }
            }
        //}
        //添加logo
        String logoimgpath="D:/logo.jpg";
        BufferedImage  logo=ImageIO.read(new File(logoimgpath));
        int logoWidth = logo.getWidth();
        int logoHeight = logo.getHeight();
        int maxHeight=bufferedImage.getHeight();
        int maxWdith=bufferedImage.getWidth();
        int X = (width - logoWidth) / 2;
        int Y = (height - logoHeight) / 2;
        //在以生成的二维码上画logo
        gs.drawImage(logo,width/5*2,height/5*2,maxWdith/5,maxHeight/5,null);
        gs.dispose();
        bufferedImage.flush();

     /*   int v =size;
        int width = 67 + 12 * (v - 1);
        int height = 67 + 12 * (v - 1);

        Qrcode q=new Qrcode();

        //容错率 ：L 7%   M 15%   Q 25%   R 30% 容错率越高，可存储的信息越少；但是对二维码清晰度要求越小
        q.setQrcodeErrorCorrect('L');
        //可存放的信息类型  注意版本信息 N代表数字 、A代表 a-z,A-Z、B代表 其他)
        q.setQrcodeEncodeMode('B');
        //尺寸：取值范围1~40
        q.setQrcodeVersion(v);
        String qrData = content;//内容信息

        byte[] d = qrData.getBytes("utf-8");//汉字转格式需要抛出异常

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);



        //创建画板
        Graphics2D gs=bufferedImage.createGraphics();
        //画图
        gs.setBackground(Color.WHITE);//画板背景颜色
        gs.setColor(Color.BLACK);//（二维码的颜色）
        gs.clearRect(0,0,width,height);//初始化

        //偏移量
        int pixoff = 2;
        //字符串-> boolean[][]
        boolean[][] codeOut=q.calQrcode(d);
        for (int i=0;i<d.length;i++){
           for (int j=0;j<d.length;j++){
               if (codeOut[j][i]) {
                   gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
               }
           }
        }
        gs.dispose();//释放空间
        bufferedImage.flush();//
*/
        return  bufferedImage;
    }

    public static void main(String[] args) throws IOException {
        MakeQRCodeUtil.encodeQRCode("https://www.baidu.com","D:/二维码.png","png",7);
    }
   /* public static void main(String[] args) throws IOException {

        //计算二维码图片的高宽比
        // API文档规定计算图片宽高的方式 ，v是本次测试的版本号
        int v =6;
        int width = 67 + 12 * (v - 1);
        int height = 67 + 12 * (v - 1);


        Qrcode x = new Qrcode();
        *//**
         * 纠错等级分为
         * level L : 最大 7% 的错误能够被纠正；
         * level M : 最大 15% 的错误能够被纠正；
         * level Q : 最大 25% 的错误能够被纠正；
         * level H : 最大 30% 的错误能够被纠正；
         *//*
        x.setQrcodeErrorCorrect('L');
        x.setQrcodeEncodeMode('B');//注意版本信息 N代表数字 、A代表 a-z,A-Z、B代表 其他)
        x.setQrcodeVersion(v);//版本号  1-40
        String qrData = "https://www.onlybigroc.cn";//内容信息

        byte[] d = qrData.getBytes("utf-8");//汉字转格式需要抛出异常

        //缓冲区
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        //绘图
        Graphics2D gs = bufferedImage.createGraphics();

        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0, 0, width, height);//初始化

        //偏移量
        int pixoff = 2;


        *//**
         * 容易踩坑的地方
         * 1.注意for循环里面的i，j的顺序，
         *   s[j][i]二维数组的j，i的顺序要与这个方法中的 gs.fillRect(j*3+pixoff,i*3+pixoff, 3, 3);
         *   顺序匹配，否则会出现解析图片是一串数字
         * 2.注意此判断if (d.length > 0 && d.length < 120)
         *   是否会引起字符串长度大于120导致生成代码不执行，二维码空白
         *   根据自己的字符串大小来设置此配置
         *//*
        if (d.length > 0 && d.length < 120) {
            boolean[][] s = x.calQrcode(d);

            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                    }
                }
            }
        }
        gs.dispose();
        bufferedImage.flush();
        //设置图片格式，与输出的路径
        ImageIO.write(bufferedImage, "png", new File("D:/qrcode.png"));
        System.out.println("二维码生成完毕");
    }*/
}