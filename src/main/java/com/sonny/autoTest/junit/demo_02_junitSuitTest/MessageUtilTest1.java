package com.sonny.autoTest.junit.demo_02_junitSuitTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageUtilTest1 {

    @Test
    public void testPrintMessage() {
        String message = "Robert";
        MessageUtil messageUtil = new MessageUtil(message);

        System.out.println("Inside testPrintMessage()");
        assertEquals(message, messageUtil.printMessage());
    }
}
