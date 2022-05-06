package com.comp62542.backend.util;

import java.util.UUID;

public class CommonUtils {

    public static String generateUUID() {
        String[] uid = UUID.randomUUID().toString().split("-");
        return uid[0];
    }

    public static void main(String[] args) {
        System.out.println(generateUUID());
    }

}
