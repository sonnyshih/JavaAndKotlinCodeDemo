package com.sonny.autoTest.junit.demo_02_junitSuitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MessageUtilTest1.class,
        MessageUtilTest2.class
})
public class TestSuiteClass {

}
