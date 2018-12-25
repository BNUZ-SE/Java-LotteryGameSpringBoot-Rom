package com.rom.javagame.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2Date {
    public static Date stringToDate(String source, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (Exception e) {
        }
        return date;
    }
}
