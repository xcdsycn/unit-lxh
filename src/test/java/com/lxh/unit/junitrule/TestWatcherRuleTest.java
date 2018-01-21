package com.lxh.unit.junitrule;
/**
 * Created by lxh on 2018/1/21.
 */

import org.junit.AssumptionViolatedException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * TestWatcher 定义了五个触发点，分别是测试成功，测试失败，测试开始，测试完成，测试跳过，能让我们在每个触发点执行自定义的逻辑。
 * @author lxh
 * @Date 2018/1/21
 */
public class TestWatcherRuleTest {
    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println(description.getDisplayName() + " Succeed");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(description.getDisplayName() + " Fail");
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.println(description.getDisplayName() + " Skipped");
        }

        @Override
        protected void starting(Description description) {
            System.out.println(description.getDisplayName() + " Started");
        }

        @Override
        protected void finished(Description description) {
            System.out.println(description.getDisplayName() + " finished");
        }
    };

    @Test
    public void testTestWatcher() {
    /*
        测试执行后会有以下输出：
        testTestWatcher(org.haibin369.test.RulesTest) Started
        Test invoked
        testTestWatcher(org.haibin369.test.RulesTest) Succeed
        testTestWatcher(org.haibin369.test.RulesTest) finished
     */
        System.out.println("Test invoked");
    }

}
