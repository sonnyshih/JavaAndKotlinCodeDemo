package com.sonny.autoTest.junit.demo_02_junitSuitTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuiteClass.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
