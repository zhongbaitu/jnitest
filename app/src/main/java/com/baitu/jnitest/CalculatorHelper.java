package com.baitu.jnitest;

/**
 * Created by baitu on 16/6/30.
 */
public class CalculatorHelper {

    static {
        System.loadLibrary("calculator");
    }

    public native static int add(int a, int b);
    public native static int sub(int a, int b);
}
