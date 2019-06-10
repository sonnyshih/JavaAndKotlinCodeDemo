package com.sonny.autoTest.junit.demo_02_junitSuitTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageUtilTest2 {


    @Test
    public void testSalutationMessage() {
        String message = "Robert";
        MessageUtil messageUtil = new MessageUtil(message);

        System.out.println("Inside testSalutationMessage()");
        message = "Hi!" + "Robert";
        assertEquals(message,messageUtil.salutationMessage());
    }
}
