package com.lxh.unit.junitrule;
/**
 * Created by lxh on 2018/1/21.
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

/**
 * ErrorCollector允许我们收集多个错误，并在测试执行完后一次过显示出来
 * @author lxh
 * @Date 2018/1/21
 */
public class ErrorCollectorRuleTest {
    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void testErrorCollector() {
        errorCollector.addError(new Exception("Test Fail 1"));
        errorCollector.addError(new Throwable("fff"));
    }
}
