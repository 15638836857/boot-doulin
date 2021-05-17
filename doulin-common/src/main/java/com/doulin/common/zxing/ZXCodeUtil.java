package com.doulin.common.zxing;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;

public class ZXCodeUtil {
   /* private String content;                //二维码内容
    private String qrCodeUrl;          //二维码网络路径
    private String filePath;           //二维码生成物理路径 也可以是文件的绝对路径
    private String fileName;           //二维码生成图片名称（包含后缀名）
    private String imageFormat;       //二维码图片后缀名(jpg、png）
    private String logoPath;           //logo图片
    private Integer width = 300;           //二维码宽度
    private Integer height = 300;          //二维码高度*/
   /* private Integer onColor = 0xFF000000;  //前景色 黑色
    private Integer bgColor = 0xFFFFFFFF; //背景色 白色
    private Integer margin = 2;            //白边大小，取值范围0~4
    private ErrorCorrectionLevel level = ErrorCorrectionLevel.M;  //二维码容错率指 纠错级别（L 7%、M 15%、Q 25%、H 30%）
*/
    private static  int BLACK = 0xFF000000;//用于设置图案的颜色
    private static  int WHITE = 0xFFFFFFFF; //用于背景色
    //加密

    /**
     * 生成包含字符串信息的二维码图片
     * @param imgpath 保存文件路径
     * @param formatimge 二维码图片格式
     * @param content 二维码携带信息
     * @param width 二维码图片的宽度
     * @param height
     * @param logopath
     * @throws Exception
     */
    public static void encodeImage(String imgpath,String formatimge,String content,int width,int height,String logopath) throws Exception {
        File file=new File(imgpath);
        if(!file.exists()){
            file.mkdirs();
        }


        Map <EncodeHintType,Object> hints=new Hashtable <>();
        //排错率 L<M<Q<H
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); // 指定纠错等级
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 指定编码格式
        hints.put(EncodeHintType.MARGIN,1);//外边距
        /**
         * content 加密的内容
         * BarcodeFormat.QR_CODE 要解析的类型
         * hints 加密涉及的一些参数：编码、排错率
         */
        BitMatrix bitMatrix=new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,width,height,hints);
       //内存中的图片
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int x=0;x<width;x++){
            for (int y = 0; y < height; y++) {
                /*int[] rgbBlack=new int[]{0,0,0};
                int[] rgbWhite=new int[]{255,255,255};*/
                bufferedImage.setRGB(x,y,(bitMatrix.get(x,y)?BLACK:WHITE));
            }
        }
        //logo

       bufferedImage= LogoUtil.logoMatrix(bufferedImage,logopath);

        //生成二维码图片
        ImageIO.write(bufferedImage,formatimge,file);
    }

    public static void main(String[] args) throws Exception {
        ZXCodeUtil.encodeImage("D:/zxing.gif","gif","在海南的朋友们想买野生土蜂蜜可以找我哟！！！！",300,300,"D:/1.png");
           //File file=new File("D:/2.png");
           //String string=ReadUtil.decodeImg(file);
      //  System.out.println("string=="+string);

       /* QrCodeUtil qrCodeUtil=new QrCodeUtil();
        qrCodeUtil.setFilePath("D:/zxing2.gif");
        qrCodeUtil.setImageFormat("gif");
        qrCodeUtil.setContent("com");
        qrCodeUtil.setWidth(200);
        qrCodeUtil.setHeight(200);
        qrCodeUtil.setLogoPath("d:/1.png");
        qrCodeUtil.createQRCode();*/
    }
    }

