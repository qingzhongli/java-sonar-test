package com.qingzhongli.sonartest;

import java.util.regex.Pattern;

public class Main {

    // This matches URIs of formats: host:port and protocol://host:port
    // IPv6 is supported with [ip] pattern
    // Reference https://github.com/apache/kafka/blob/trunk/clients/src/main/java/org/apache/kafka/common/utils/Utils.java#L97
    // https://community.appway.com/screen/kb/article/checking-strings-avoiding-catastrophic-backtracking-1482810891360
    private static final String ENDPOINT_REGEX = "([^\\n]+)?\\[?([0-9a-zA-Z\\-%._:]*)\\]?:(\\d+)";
    //private static final String ENDPOINT_REGEX = "([^\\n]+)[^\\n]+\\[?([0-9a-zA-Z\\-%._:]*)\\]?:(\\d+)";


    public static void main(String[] args) {
        System.out.println(Pattern.matches(ENDPOINT_REGEX, ""));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "test"));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "[2001:db8:85a3::8a2e:370:7334]:9092"));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "[2001:db8:85a3::8a2e:370:7334]:9092"));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "[2001:0db8:85a3:0000:0000:8a2e:0370:7335]:9092"));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "192.168.164.136:9092"));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "PLAINTEXT://[2001:db8:85a3::8a2e:370:7334]:9092"));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "SSL://[2001:db8:85a3::8a2e:370:7334]:9092"));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "SASL_PLAINTEXT://[2001:0db8:85a3:0000:0000:8a2e:0370:7335]:9092"));
        System.out.println(Pattern.matches(ENDPOINT_REGEX, "SASL_SSL://192.168.164.136:9092"));
    }

}
