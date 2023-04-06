package com.forezp.date;

import org.springframework.util.StringUtils;

import java.util.Scanner;

/**
 * 毫秒转换 为时 分 秒  输入一个毫秒数 12000  转为中文 12秒
 */
public class MilliSecondFormat {

    public static String format(long milliSeconds) {
        long seconds = milliSeconds / 1000;
        long hours = seconds / 3600;
        seconds = seconds % 3600;
        long minutes = seconds / 60;
        seconds = seconds % 60;
        StringBuilder sb = new StringBuilder();
        if (hours > 0) {
            sb.append(hours + "小时");
        }
        if (minutes > 0) {
            sb.append(minutes + "分钟");
        }
        if (seconds > 0) {
            sb.append(seconds + "秒");
        }
        return StringUtils.isEmpty(sb.toString()) ? "0秒" : sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            long milliseconds = sc.nextLong();
            String str = format(milliseconds);
            System.out.println(str);
        }
    }
}
