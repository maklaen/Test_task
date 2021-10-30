package com.test.test_project.util;

public class FormatUtil {
    public static String toNameFormat(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
}
