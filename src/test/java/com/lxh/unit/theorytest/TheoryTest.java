package com.lxh.unit.theorytest;
/**
 * Created by lxh on 2018/1/21.
 */

import com.lxh.unit.junitparameterized.Calculator;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

/**
 * 只需给定了一些数据，JUnit自动利用这些数据组合出各种各种可能的组合来执行测试
 * @author lxh
 * @Date 2018/1/21
 */
@RunWith(Theories.class)
public class TheoryTest {

    //允许的最大误差
    private static final double DELTA = 0.01;

    @DataPoint
    public static int ZERO = 0;

    @DataPoint
    public static int TWO = 2;

    @DataPoint
    public static int EIGHT = 8;

    //标志这个测试为Theory测试
    @Theory
    public void testDivide(int dividend, int divisor) {
        /**
         * 跳过除数为0的case
         * 本应该是两两组合，结果被跳过了，所以没有那么多的组合数据
         * 这个不输出异常的方法好
         */
        assumeThat(divisor, not(0));
        //Calculator.divide(dividend, divisor)方法返回他们相除的结果
        assertEquals(dividend / divisor, Calculator.divide(dividend, divisor), DELTA);
        System.out.println("Passed with: dividend=" + dividend + ", divisor=" + divisor);
    }

}
