package com.rom.javagame.utils;

import java.io.UnsupportedEncodingException;

import java.util.Base64;

public class base64Utils {
    static Base64.Decoder decoder = Base64.getDecoder();
    static Base64.Encoder encoder = Base64.getEncoder();
    //编码
    public static String decodeBase64(String text) {
        try {
            byte[] textByte = text.getBytes("UTF-8");
            return encoder.encodeToString(textByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    //解码
    public static String encodeBase64(String encodeedText) {
        try {
            return new String(decoder.decode(encodeedText), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
