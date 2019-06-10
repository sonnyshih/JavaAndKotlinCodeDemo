package com.sonny.autoTest.junit.demo_01_basic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CalculatorJUintTest {
    @Before
    public void SetUp(){
        System.out.println("Before: setup()");
    }

    @Test
    public void testAddPass() {
        Calculator calculator = new Calculator();
        // assertEquals(String message, long expected, long actual)
        assertEquals("error in add()",  3, calculator.add(1, 2));
        assertEquals("error in add()", -3, calculator.add(-1, -2));
        assertEquals("error in add()",  9, calculator.add(9, 0));
    }

    @Test
    public void testAddFail() {
        Calculator calculator = new Calculator();
        // assertNotEquals(String message, long expected, long actual)
        assertNotEquals("error in add()", 0, calculator.add(1, 2));
    }

    @Test
    public void testSubPass() {
        Calculator calculator = new Calculator();
        assertEquals("error in sub()",  1, calculator.sub(2, 1));
        assertEquals("error in sub()", -1, calculator.sub(-2, -1));
        assertEquals("error in sub()",  0, calculator.sub(2, 2));
    }

    @Test
    public void testSubFail() {
        Calculator calculator = new Calculator();
        assertNotEquals("error in sub()", 0, calculator.sub(2, 1));
    }

    @After
    public void tearDown(){
        System.out.println("After: tearDown()");

    }

}
