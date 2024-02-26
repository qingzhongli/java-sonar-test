package com.qingzhongli.sonartest;

import java.util.regex.Pattern;
import java.util.logging.Logger;

public class Main {

    // This matches URIs of formats: host:port and protocol://host:port
    // IPv6 is supported with [ip] pattern
    // Reference https://github.com/apache/kafka/blob/trunk/clients/src/main/java/org/apache/kafka/common/utils/Utils.java#L97
    private static final String ENDPOINT_REGEX = ".+?\\[?([0-9a-zA-Z\\-%._:]*)\\]?:(\\d+)";

    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();

        String test = "";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test = "test";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test = "[2001:db8:85a3::8a2e:370:7334]:9092";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test ="[2001:db8:85a3::8a2e:370:7334]:9092";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test ="[2001:0db8:85a3:0000:0000:8a2e:0370:7335]:9092";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test ="192.168.164.136:9092";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test ="PLAINTEXT://[2001:db8:85a3::8a2e:370:7334]:9092";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test ="SSL://[2001:db8:85a3::8a2e:370:7334]:9092";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test ="SASL_PLAINTEXT://[2001:0db8:85a3:0000:0000:8a2e:0370:7335]:9092";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));

        test ="SASL_SSL://192.168.164.136:9092";
        logger.info("test result: " + Pattern.matches(ENDPOINT_REGEX, test));
    }

}
