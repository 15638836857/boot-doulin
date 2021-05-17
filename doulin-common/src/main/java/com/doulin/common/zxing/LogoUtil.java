package com.doulin.common.zxing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LogoUtil {
    public static BufferedImage logoMatrix(BufferedImage bufferedImage,String logopath) throws IOException {
        //在二维码上画logo:产生一个 二维码画板
        Graphics2D graphics2D=bufferedImage.createGraphics();

        BufferedImage logoImg= ImageIO.read(new File(logopath));
        int width=bufferedImage.getWidth();
        int height=bufferedImage.getHeight();

        //logo
        graphics2D.drawImage(logoImg,width*2/5,height*2/5,width*1/5,height*1/5,null);

        //画笔
        BasicStroke stroke=new BasicStroke(5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);

        //关联画笔
        graphics2D.setStroke(stroke);
        //创建一个正方形
        RoundRectangle2D.Float round=new RoundRectangle2D.Float(width*2/5,height*2/5,width*1/5,height*1/5,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        graphics2D.setColor(Color.WHITE);//白色
        graphics2D.draw(round);
        //灰色
        BasicStroke stroke2=new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        graphics2D.setStroke(stroke2);

        RoundRectangle2D.Float round2=new RoundRectangle2D.Float(width*2/5+2,height*2/5+2,width*1/5-4,height*1/5-4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND);
        graphics2D.setColor(Color.GRAY);//灰色
        graphics2D.draw(round2);

        graphics2D.dispose();
        bufferedImage.flush();
        return  bufferedImage;
    }
}
