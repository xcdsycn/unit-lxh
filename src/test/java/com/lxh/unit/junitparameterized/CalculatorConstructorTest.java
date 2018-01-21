package com.lxh.unit.junitparameterized;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 使用Parameterized Runner执行参数化测试
 * 1.构造函数形式，即JUnit遍历所提供的所有参数调用构造函数并执行测试方法
 * Created by lxh on 2018/1/21.
 */
@RunWith(Parameterized.class)
public class CalculatorConstructorTest {
    //允许误差
    private static final double DELTA = 0.0001;

    private int dividend;
    private int divisor;
    private int result;

    public CalculatorConstructorTest(int dividend, int divisor, int result) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.result = result;
    }

    /**
     * 用@Parameterized.Parameters注解标注该方法是返回所有参数，被注解的方法必须返
     * 回装载数组的Iterable对象，同时必须为public，static，当测试执行时，系统会遍历
     * 每组参数（数组）调用构造函数并执行测试。
     * @return
     */
    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {9, 3, 3}, {5, 1, 5}, {12, 4, 3}
        });
    }

    /**
     * 当执行测试后，该方法会运行3次
     * 使用三组构造函数的参数
     */
    @Test
    public void testDevide ()throws Exception{
        assertEquals(result, Calculator.divide(dividend, divisor), DELTA);
    }
}