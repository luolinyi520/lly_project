package com.lly.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.logging.Logger;

public class Test {

    public static void main(String[] args) {
        Log log = LogFactory.getLog(Test.class);
        log.info("start...");
        log.warn("end.");
    }

}
