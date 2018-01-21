package com.lxh.unit.junitparameterized;
/**
 * Created by lxh on 2018/1/21.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

/**
 * 使用 Parameterized Runner执行参数化测试
 * 变量注入形式，变量的值不通过构造函数初始化，而是通过JUnit注入
 * @author lxh
 * @Date 2018/1/21
 */
@RunWith(Parameterized.class)
public class CalculatorSettingTest {
    /**
     * 允许误差
     *
     */
    private static final double DELTA = 0.01;

    /**
     * 使用@Parameter标注public变量，JUnit会遍历每组参数进行注入
     *注解中的整数参数表示注入参数组中的第几个参数
     */
    @Parameterized.Parameter(0)
    public int dividend;
    @Parameterized.Parameter(1)
    public int divisor;
    @Parameterized.Parameter(2)
    public int result;

    /**
     * 用@Parameterized.Parameters注解标注该方法是返回所有参数，被注解的方法必须返
     * 回装载数组的Iterable对象，同时必须为public，static，当测试执行时，系统会遍历
     * 每组参数（数组）调用构造函数并执行测试。
     */
    @Parameterized.Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                {9, 3, 3}, {5, 0, 5}, {12, 4, 3}
        });
    }

    /**
     * 当执行测试后，该方法会运行3次
     *  使用上述参数执行该测试，第二组参数所对应的测试会被忽略，而不是失败。
     * Assumption
     * 测试数据的问题，不应该导致测试失败
     * 使用org.junit.Assume下的各种assume方法能对测试的数据或者环境做出假设，
     * 当这种假设不满足时跳过该测试，这样就可以保证在正确的测试环境下执行测试。
     * @throws Exception
     */
    @Test
    public void testDivide() throws Exception {
        /**
         * 假定除数不为0，若为0跳过该测试
         * 虽然提示异常，但是测试结果是正确的，可以通过的，因为你预料到了这个异常，如果不是 true
         * 那么这个测试被跳过了，去执行下一个测试了
         */
        assumeTrue("Divisor can't be 0", divisor != 0);
        assertEquals(result, Calculator.divide(dividend, divisor), DELTA);
    }
}
