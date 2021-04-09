package com.lly.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Person {
    protected final Log log = LogFactory.getLog(getClass());

    void foo() {
        log.info("foo");
    }
}
