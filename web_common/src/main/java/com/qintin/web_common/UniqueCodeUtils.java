package com.qintin.web_common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UniqueCodeUtils {

    /**
     * 获取当前时间+5位随机数的唯一码
     *
     * @return 唯一码
     */
    public static String generateUniqueCode() {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 格式化日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dateStr = now.format(formatter);

        // 生成 5 位随机数
        Random random = new Random();
        int randomNumber = random.nextInt(90000) + 10000;

        // 组合成唯一码
        String uniqueCode = dateStr + randomNumber;

        return uniqueCode;
    }
}