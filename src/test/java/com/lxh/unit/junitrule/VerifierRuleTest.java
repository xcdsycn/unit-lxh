package com.lxh.unit.junitrule;
/**
 * Created by lxh on 2018/1/21.
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Verifier;

/**
 * Verifier是ErrorCollector的父类，可以在测试执行完成之后做一些校验，以验证测试结果是不是正确
 * @author lxh
 * @Date 2018/1/21
 */
public class VerifierRuleTest {
    String result;

    @Rule
    public Verifier verifier = new Verifier() {
        /**
         * 当测试执行完之后会调用verify方法验证结果，抛出异常表明测试失败
         *
         * @throws Throwable
         */
        @Override
        protected void verify() throws Throwable {
            if (!"Success".equals(result)) {
                throw new Exception("Test Fail.");
            }
        }
    };

    @Test
    public void testVerifier() {
        result = "Fail";
    }
}
