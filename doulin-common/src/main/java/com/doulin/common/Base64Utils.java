package com.doulin.common;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class Base64Utils {
    // 字节数组转Base64编码
    public static String byte2Base64(byte[] bytes) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(bytes);
    }

    // Base64编码转字节数组
    public static byte[] base642Byte(String base64Key) throws IOException {
        BASE64Decoder decoder = new BASE64Decoder();
        return decoder.decodeBuffer(base64Key);
    }

    public String js_getBase64(String imgPath) {
        byte[] data = null;
// 读取图片字节数组
        String image = imgPath.substring(8);
        try {
            InputStream in = new FileInputStream(image);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
// 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
// 返回Base64编码过的字节数组字符串
        String strLocalImageToBase64 = encoder.encode(Objects.requireNonNull(data));
        return strLocalImageToBase64;//base64编码
    }

}
