package org.example.view;

/**
 * @Description:
 * @Author: mzvltr
 * @Date: 2024/11/6
 */
public class Logger {
    public static void log(String format, Object... args) {
        System.out.printf(format, args);
    }
}
