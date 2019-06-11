package com.sonny.autoTest.junit.demo_03_Parameterization;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DemoTest1 {

    @Test
    @Parameters({"AAA,1", "BBB,2"})
    public void paramsInAnnotation(String p1, Integer p2) {
        System.out.println("P1="+p1);
        System.out.println("P2="+p2);
    }

    @Test
    @Parameters(method = "testAddData")
    public void testCase2(int issue, int second, int expectedSum) {
        System.out.println("issue: "+ issue + " second: " + second + " expectedSum" + expectedSum);
//        Calculator calculator = new Calculator();
//
//        int actualSum = calculator.add(issue.getId(), second);
//
//        assertThat(actualSum).isEqualByComparingTo(expectedSum);
    }

    /** 建立指定的方法並回傳資料陣列 指到 @Parameters(method = "testAddData") **/
    private Object[] testAddData() {
        return new Object[]{
                new Object[]{ 1, 2, 3},     // issue, second, expectedSum
                new Object[]{ 5, 10, 15}    // issue, second, expectedSum
        };
    }
}
