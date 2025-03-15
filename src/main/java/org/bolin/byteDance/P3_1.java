package org.bolin.byteDance;

import java.text.DecimalFormat;

public class P3_1 {
    public static String formatNumber(String s) {

        int i = 0;
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        s = (i == s.length()) ? "0" : s.substring(i);

        // 分割整数部分和小数部分
        String[] parts = s.split("\\.");
        String integerPart = parts[0];
        String decimalPart = parts.length > 1 ? parts[1] : "";

        // 为整数部分添加千分位逗号
        StringBuilder sb = new StringBuilder();
        int len = integerPart.length();
        int count = 0;


        for (int j = len - 1; j >= 0; j--) {
            sb.append(integerPart.charAt(j));
            count++;
            if (count % 3 == 0 && j != 0) {
                sb.append(',');
            }
        }
        sb.reverse();


        if (!decimalPart.isEmpty()) {
            return sb.toString() + "." + decimalPart;
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(formatNumber("1294512.12412"));   // 输出: '1,294,512.12412'
        System.out.println(formatNumber("0000123456789.99")); // 输出: '123,456,789.99'
        System.out.println(formatNumber("987654321"));       // 输出: '987,654,321'
    }
}
