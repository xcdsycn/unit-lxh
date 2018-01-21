package com.lxh.unit.junitrule;
/**
 * Created by lxh on 2018/1/21.
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import java.io.File;
import java.io.IOException;

/**
 * @author lxh
 * @Date 2018/1/21
 */
public class ExternalResourceRuleTest {
    File tempFile;

    /**
     * ExternalResource 是TemporaryFolder的父类，主要用于在测试之前创建资源，并在测试完成后销毁
     * 本例是以文件为例，外部资源有可能是数据库连接之类的，不一定是文件系统
     */
    @Rule
    public ExternalResource extResource = new ExternalResource() {
        /**
         *   每个测试执行之前都会调用该方法创建一个临时文件
         */
        @Override
        protected void before() throws Throwable {
            tempFile = File.createTempFile("test", ".txt");
        }

        /**
         * 每个测试执行之后都会调用该方法删除临时文件
         */
        @Override
        protected void after() {
            tempFile.delete();
        }
    };

    @Test
    public void testExtResource() throws IOException {
        System.out.println(tempFile.getCanonicalPath());
    }
}
