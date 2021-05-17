package com.doulin.common.zxing;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Hashtable;
/**
 *
 * 二维码生成和读的工具类 使用google 开发的 zxing
 * 参数介绍：
 *      ZXing采用Hashtable方式来保存设置参数：纠错能力为 L 级别，设置编码类型为UTF-8
 *      位矩阵二维码数据 BitMatrix
 */
public class QrCodeUtil {
    private String content;                //二维码内容
    private String qrCodeUrl;          //二维码网络路径
    private String filePath;           //二维码生成物理路径 也可以是文件的绝对路径
    private String fileName;           //二维码生成图片名称（包含后缀名）
    private String imageFormat;       //二维码图片后缀名(jpg、png）
    private String logoPath;           //logo图片
    private Integer width = 300;           //二维码宽度
    private Integer height = 300;          //二维码高度
    private Integer onColor = 0xFF000000;  //前景色 黑色
    private Integer bgColor = 0xFFFFFFFF; //背景色 白色
    private Integer margin = 2;            //白边大小，取值范围0~4
    private ErrorCorrectionLevel level = ErrorCorrectionLevel.M;  //二维码容错率指 纠错级别（L 7%、M 15%、Q 25%、H 30%）

    /**
     * 生成二维码 属性：content、fileName、filePath不得为空
     * @throws Exception
     */
    public void createQRCode() throws Exception {
        String imgPath = this.getFilePath();
        String imgName = this.getFileName();
        String content = this.getContent();
        String imageFormat = this.getImageFormat();
        if (imageFormat == null || imgPath == null || content == null) throw new Exception("参数错误");
        boolean flag;
        String[]  arr=filePath.split("\\.");
        if(arr.length==1) flag=true;
        else if(arr.length==2) flag=false;
        else throw new Exception("判断路径类型错误");
        if(flag) {//imgPath 是物理路径
            if (this.getLogoPath() != null && !"".equals(this.getLogoPath().trim()))
                generateQRCodeWithLogo(content, this.getLogoPath(), imgPath, imgName, imageFormat);
            else generateQRCode(content, imgPath, imgName, imageFormat);
        }else{//imgPath 是绝对路径
            if (this.getLogoPath() != null && !"".equals(this.getLogoPath().trim())) generateQRCodeWithLogo(content, this.getLogoPath(), imgPath, imageFormat);
            else generateQRCode(content, imgPath, imageFormat);
        }
    }
    /**
     * 生成二维码
     * @param content       //二维码内容
     * @param imgPath      //二维码保存物理路径
     * @param imgName      //二维码文件名称
     * @param suffix       //图片后缀名
     */
    public void generateQRCode(String content, String imgPath, String imgName, String suffix) throws Exception{
        File filePath = new File(imgPath);
        if(!filePath.exists()){
            throw new Exception("文件路径不存在");
        }
        File imageFile = new File(imgPath,imgName);
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, level); // 指定纠错等级
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 指定编码格式
        hints.put(EncodeHintType.MARGIN, this.getMargin());//设置白边
        MatrixToImageConfig config = new MatrixToImageConfig( this.getOnColor() , this.getBgColor());
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, this.getWidth(), this.getHeight(), hints);
//      bitMatrix = deleteWhite(bitMatrix);
        MatrixToImageWriter.writeToPath(bitMatrix, suffix, imageFile.toPath(), config);

    }
    /**
     * 生成二维码
     * @param content       //二维码内容
     * @param path          //二维码保存文件 绝对路径 如：d:\\qrcode.jpg)
     * @param suffix       //图片后缀名
     */
    public void generateQRCode(String content, String path, String suffix) throws Exception{
        File imageFile = new File(path);
        if (!imageFile.getParentFile().exists()) {
            imageFile.getParentFile().mkdirs();
        }
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, level); // 指定纠错等级
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // 指定编码格式
        hints.put(EncodeHintType.MARGIN, this.getMargin());//设置白边
        MatrixToImageConfig config = new MatrixToImageConfig( this.getOnColor() , this.getBgColor());
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, this.getWidth(), this.getHeight(), hints);
        MatrixToImageWriter.writeToPath(bitMatrix, suffix, imageFile.toPath(), config);
    }
    /**
     * 生成带logo的二维码图片
     * @param content       //二维码内容
     * @param logoPath     //logo绝对物理路径
     * @param imgPath      //二维码保存绝对物理路径
     * @param imgName      //二维码文件名称
     * @param suffix       //图片后缀名
     * @throws Exception
     */
    public void generateQRCodeWithLogo(String content, String logoPath, String imgPath, String imgName, String suffix) throws Exception{
        File filePath = new File(imgPath);
        if(!filePath.exists()){
            filePath.mkdirs();
        }
        if(imgPath.endsWith("/")){
            imgPath += imgName;
        }else{
            imgPath += "/"+imgName;
        }
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, this.getLevel());
        hints.put(EncodeHintType.MARGIN, this.getMargin());  //设置白边
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, this.getWidth(), this.getHeight(), hints);
        File qrcodeFile = new File(imgPath);
        writeToFile(toBufferedImage(bitMatrix), suffix, qrcodeFile, logoPath);
    }
    /**
     * 生成带logo的二维码图片
     * @param content       //二维码内容
     * @param logoPath     //logo绝对物理路径
     * @param path         //二维码保存文件 绝对路径 如：d:\\qrcode.jpg)
     * @param suffix       //图片后缀名
     * @throws Exception
     */
    public void generateQRCodeWithLogo(String content, String logoPath, String path, String suffix) throws Exception{
        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, this.getLevel());
        hints.put(EncodeHintType.MARGIN, this.getMargin());  //设置白边
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, this.getWidth(), this.getHeight(), hints);
        File qrcodeFile = new File(path);
        writeToFile(toBufferedImage(bitMatrix), suffix, qrcodeFile, logoPath);
    }
    /**
     * @param image 二维码矩阵相关
     * @param format 二维码图片格式
     * @param file 二维码图片文件
     * @param logoPath logo路径
     * @throws IOException
     */
    public  void writeToFile( BufferedImage image,String format,File file,String logoPath) throws Exception {
        //读取二维码图片
        Graphics2D gs = image.createGraphics();
        int ratioWidth = image.getWidth()*2/10;
        int ratioHeight = image.getHeight()*2/10;
        //载入logo
        Image img = ImageIO.read(new File(logoPath));
        //设置二维码覆盖（logo大小），太大会覆盖二维码，此处20%
        int logoWidth = img.getWidth(null)>ratioWidth?ratioWidth:img.getWidth(null);
        int logoHeight = img.getHeight(null)>ratioHeight?ratioHeight:img.getHeight(null);
        //设置logo图片放置位置
        int x = (image.getWidth() - logoWidth) / 2;
        int y = (image.getHeight() - logoHeight) / 2;
        gs.drawImage(img, x, y, logoWidth, logoHeight, null);
        //logo边框大小
        gs.setStroke(new BasicStroke(1));
        // gs.setColor(Color.black);
//        gs.drawRect(x, y, logoWidth, logoHeight);
        gs.setBackground(Color.WHITE);

        gs.dispose();
        img.flush();
        if(!ImageIO.write(image, format, file)){
            throw new Exception("不能把图片"+file+"转成" + format + " 格式 ");
        }
    }
    //把数据放入图片缓冲区
    public BufferedImage toBufferedImage(BitMatrix matrix){
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                image.setRGB(x, y, matrix.get(x, y) ? this.getOnColor() : this.getBgColor());
            }
        }
        return image;
    }

    /**
     * 读二维码并输出携带的信息
     */
    public String readQrCode() throws Exception{
        File filePath = new File(this.getFilePath());
        if(!filePath.exists()){
            throw new Exception("文件不存在");
        }
        InputStream inputStream=new FileInputStream(filePath);
        //从输入流中获取字符串信息
        BufferedImage image = ImageIO.read(inputStream);
        //将图像转换为二进制位图源
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        Result result = reader.decode(bitmap);
        return result.getText();
    }

    /**
     * 生成包含字符串信息的二维码图片
     * @param saveImgPath 文件输出流路径
     * @param content 二维码携带信息
     * @param qrCodeWidth 二维码图片宽度
     * @param qrCodeHeight 二维码图片高度
     * @param imageFormat 二维码的格式
     * @throws WriterException
     * @throws IOException
     */
    public static boolean createQrCode(String saveImgPath, String content, int qrCodeWidth, int qrCodeHeight, String imageFormat) throws Exception{
        File filePath = new File(saveImgPath);
        OutputStream outputStream=new FileOutputStream(filePath);
        Hashtable<EncodeHintType, Object> hashtable = new Hashtable<>();//
        hashtable.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // 指定纠错等级,纠错级别（L 7%、M 15%、Q 25%、H 30%）
        hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");// 使用字符集编码
        hashtable.put(EncodeHintType.MARGIN, 1);//设置二维码边的空度，非负数
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //创建比特矩阵(位矩阵)的QR码编码的字符串
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, qrCodeWidth, qrCodeHeight, hashtable);
        // 使BufferedImage勾画QRCode  (matrixWidth 是行二维码像素点)
        int matrixWidth = bitMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth-200, matrixWidth-200, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        graphics.setColor(Color.BLACK);
        // 使用比特矩阵画并保存图像
        for (int i = 0; i < matrixWidth; i++){
            for (int j = 0; j < matrixWidth; j++){
                if (bitMatrix.get(i, j)){
                    graphics.fillRect(i-100, j-100, 1, 1);
                }
            }
        }
        return ImageIO.write(image, imageFormat, outputStream);
    }

    /**
     * 读二维码并输出携带的信息
     */
    public static String readQrCode(String imgPath) throws Exception{
        File filePath = new File(imgPath);
        if(!filePath.exists()){
            throw new Exception("文件不存在");
        }
        InputStream inputStream=new FileInputStream(filePath);
        //从输入流中获取字符串信息
        BufferedImage image = ImageIO.read(inputStream);
        //将图像转换为二进制位图源
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        Result result = reader.decode(bitmap);
        return result.getText();
    }


    /**
     * 测试代码
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //静态方法
        //createQrCode(new FileOutputStream(new File("d:\\qrcode.jpg")),"德玛西亚",200,200,"JPEG");
        //readQrCode("d:\\142.png");
        //使用对象 生成二维码
        QrCodeUtil qrCodeUtil=new QrCodeUtil();
        qrCodeUtil.setContent("在海南的朋友们想买野生土蜂蜜可以找我哟！！！！");
        qrCodeUtil.setFilePath("d:/qrcode.jpg");
        qrCodeUtil.setImageFormat("jpeg");
        qrCodeUtil.setLogoPath("d:/1.png");
        qrCodeUtil.setWidth(300);
        qrCodeUtil.setHeight(300);
        qrCodeUtil.createQRCode();//生成二维码
        //使用对象 读取二维码
       // QrCodeUtil qqq=new QrCodeUtil();
//        String result= qqq.readQrCode();
//        String result= QrCodeUtil.readQrCode("d:/142.png");
       // System.out.println(result);

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getOnColor() {
        return onColor;
    }

    public void setOnColor(Integer onColor) {
        this.onColor = onColor;
    }

    public Integer getBgColor() {
        return bgColor;
    }

    public void setBgColor(Integer bgColor) {
        this.bgColor = bgColor;
    }

    public Integer getMargin() {
        return margin;
    }

    public void setMargin(Integer margin) {
        this.margin = margin;
    }

    public ErrorCorrectionLevel getLevel() {
        return level;
    }

    public void setLevel(ErrorCorrectionLevel level) {
        this.level = level;
    }

    public String getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(String imageFormat) {
        this.imageFormat = imageFormat;
    }
}
