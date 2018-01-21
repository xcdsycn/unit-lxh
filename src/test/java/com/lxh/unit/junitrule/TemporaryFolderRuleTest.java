package com.lxh.unit.junitrule;
/**
 * Created by lxh on 2018/1/21.
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

/**
 * @author lxh
 * @Date 2018/1/21
 */
public class TemporaryFolderRuleTest {
    /**
     * 创建TemporaryFolder Rule
     * 可以在构造方法上加入路径参数来指定临时目录，否则使用系统临时目录
     */
    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    /**
     * 在系统的临时目录下创建文件或者目录，当测试方法执行完毕自动删除
     * @throws IOException
     */
    @Test
    public void testTempFolderRule() throws IOException {
        File tempFile = tempFolder.newFile("test.txt");
        System.out.println("==> tempFile:" + tempFile.getCanonicalPath());

        File tempDir = tempFolder.newFolder("test");
        System.out.println("==> tempDir:" + tempDir.getCanonicalPath());

    }
}
