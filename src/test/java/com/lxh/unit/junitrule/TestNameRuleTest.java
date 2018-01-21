package com.lxh.unit.junitrule;
/**
 * Created by lxh on 2018/1/21.
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * TestName能让我们在测试中获取目前测试方法的名字。
 * @author lxh
 * @Date 2018/1/21
 */
public class TestNameRuleTest {
    @Rule
    public TestName testName = new TestName();

    @Test
    public void testTestName() {
        //打印出测试方法的名字testTestName
        System.out.println(testName.getMethodName());
    }

}
