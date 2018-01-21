package com.lxh.unit.theorytest;
/**
 * Created by lxh on 2018/1/21.
 */

import com.lxh.unit.junitparameterized.Calculator;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeThat;

/**
 * 也可以使用@DataPoints注解一个静态方法以返回数据，下面的测试与 @see TheoryTest 等价
 * @author lxh
 * @Date 2018/1/21
 */
@RunWith(Theories.class)
public class TheoryDataPointsTest {

    //允许的最大误差
    private static final double DELTA = 0.01;

    @DataPoints
    public static int[] getTestData() {
        return new int[]{0, 2, 8};
    }

    //标志这个测试为Theory测试
    @Theory
    public void testDivide(Integer dividend, Integer divisor) {
        //跳过除数为0的case
        assumeThat(divisor, not(0));
        //Calculator.divide(dividend, divisor)方法返回他们相除的结果
        assertEquals(dividend / divisor, Calculator.divide(dividend, divisor), DELTA);
        System.out.println("Passed with: dividend=" + dividend + ", divisor=" + divisor);
    }

}
