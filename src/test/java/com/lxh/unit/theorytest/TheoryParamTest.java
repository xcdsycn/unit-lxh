package com.lxh.unit.theorytest;
/**
 * Created by lxh on 2018/1/21.
 */

import com.lxh.unit.junitparameterized.Calculator;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * 要限定某个参数，可以像下面的例子一样使用@TestOn注解
 * @author lxh
 * @Date 2018/1/21
 */
@RunWith(Theories.class)
public class TheoryParamTest {
    //允许的最大误差
    private static final double DELTA = 0.01;

    //标志这个测试为Theory测试
    @Theory
    public void testDivide(
            @TestedOn(ints = {0, 2, 8}) int dividend,
            @TestedOn(ints = {2, 8}) int divisor
    ) {
        //Calculator.divide(dividend, divisor)方法返回他们相除的结果
        assertEquals(dividend / divisor, Calculator.divide(dividend, divisor), DELTA);
        System.out.println("Passed with: dividend=" + dividend + ", divisor=" + divisor);
    }
}
