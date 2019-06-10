package com.sonny.autoTest.junit.demo_01_basic;

public class MainRunner {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("add: " +  calculator.add(10, 15));
        System.out.println("sub: " +  calculator.sub(10, 15));
        System.out.println("mul: " +  calculator.mul(10, 15));
        System.out.println("divInt: " +  calculator.divInt(25, 15));
        System.out.println("divReal: " +  calculator.divReal(10, 15));
    }
}
