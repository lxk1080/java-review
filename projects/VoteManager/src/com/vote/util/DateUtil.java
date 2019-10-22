package com.vote.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * <b>
 *    处理日期   工具类
 * </b>
 *
 */
public class DateUtil {

    /**
     * 字符串日期转日期格式日期
     * @param str 字符串日期
     * @param dateFormat 字符串日期格式
     * @return
     */
    public static Date strToDate(String strDate,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (Exception e) {
        	System.out.println("日期格式转换出错");
        }
        return date;
    }
    
    /**
     * 将日期转换为字符串日期
     * @param date 日期
     * @param tarDateFormat 日期格式
     * @return
     */
    public static String dateToStr(Date date,String tarDateFormat){
        
        return new SimpleDateFormat(tarDateFormat).format(date);
    }
    
    /**
     * 转换日期格式
     * @param strDate 字符串日期
     * @param srcFormat 原始格式
     * @param tarFormat 目标格式
     * @return
     */
    public static String strToStr(String strDate,String srcFormat,String tarFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(srcFormat);
        try {
            Date date = sdf.parse(strDate);
            sdf = new SimpleDateFormat(tarFormat);
            strDate = sdf.format(date);
        } catch (Exception e) {
           System.out.println("日期格式转换出错");
        }
        return strDate;
    }
    
}