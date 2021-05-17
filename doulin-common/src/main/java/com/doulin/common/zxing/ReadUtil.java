package com.doulin.common.zxing;

import com.google.common.collect.Maps;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadUtil {

    public static  String decodeImg(File file) throws IOException, NotFoundException {
        if(!file.exists()) return "";
      BufferedImage bufferedImage= ImageIO.read(file);
        MultiFormatReader multiFormatReader= new MultiFormatReader();

        LuminanceSource luminanceSource=new BufferedImageLuminanceSource(bufferedImage);
        Binarizer binarizer=new HybridBinarizer(luminanceSource);


        BinaryBitmap binaryBitmap=new BinaryBitmap(binarizer);
        Map map= Maps.newHashMap();
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");
        Result result=multiFormatReader.decode(binaryBitmap,map);
        return  result.toString();
    }
}
