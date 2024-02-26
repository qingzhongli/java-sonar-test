package com.qingzhongli.sonartest;

import java.util.regex.Pattern;

public class Main {

    private static final String ENDPOINT_REGEX = "[^\\n]?\\[?([0-9a-zA-Z\\-%._:]*)\\]?:(\\d+)";

    public static void main(String[] args) {
        if (args.length < 1) {
            return;
        }

        String test = args[0];
        if (!Pattern.matches(ENDPOINT_REGEX, test)) {
            System.out.println(test + "not match pattern " + ENDPOINT_REGEX);
        } else {
            System.out.println("Hello World!");
        }
    }

}
