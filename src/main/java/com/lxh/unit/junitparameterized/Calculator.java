package com.lxh.unit.junitparameterized;
/**
 * Created by lxh on 2018/1/21.
 */

/**
 * @author lxh
 * @Date 2018/1/21
 */
public class Calculator {
    /**
     * 简单的计算
     * @param dividend
     * @param divisor
     * @return
     */
    public static double divide(int dividend, int divisor) {
        System.out.println("dividend:" + dividend + ",divisor:" + divisor);
        double result = dividend / divisor;
        System.out.println("result: " + result);
        return result;
    }
}
