package com.lxh.unit.junitassertthat;
/**
 * Created by lxh on 2018/1/21.
 */

import org.junit.Test;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * @author lxh
 * @Date 2018/1/21
 */
public class AssertThatTest {
    private int id = 6;
    private boolean trueValue = true;
    private Object nullObject = null;
    private String msg = "Hello World";

    /**
     * 但是这些基本的断言有些可读性并不是很好
     * 判断一个字符串以“Hello”开头，以“Workd”结尾，由于没有assertStartWith和assertEndWith之类的函数，
     * 我们不得不自己编写表达式并断言其结果。
     * 并且因为我们没有提供失败的信息，当这个断言失败时只会抛出java.lang.AssertionError，
     * 根本不知道是因为msg为null还是msg的内容错误
     * @throws Exception
     */
    @Test
    public void testAssert() throws Exception {
        assertEquals(6, id);
        assertTrue(trueValue);
        assertNull(nullObject);
        assertTrue(msg != null && msg.startsWith("Hello") && msg.endsWith("World"));
    }

    /**
     * 还有一种assertThat，需要配合org.hamcrest.Matcher使用，这种断言的语法为：
     * assertThat([reason, ]T actual, Matcher<? super T> matcher)
     * reason为断言失败时的输出信息，actual为断言的值或对象，matcher为断言的匹配器，里面的逻辑决定了给定的actual对象满不满足断言。
     * 在org.hamcrest.CoreMatchers类中组织了所有JUnit内置的Matcher，调用其任意一个方法都会创建一个与方法名字相关的Matcher。
     * @throws Exception
     */
    @Test
    public void testAssertThat() throws Exception {
        //由于静态导入了org.haibin369.matcher.MyMatchers.*，可以调用里面的
        //is(), nullValue(), containsString(), startsWith()方法，可读性更好
        assertThat(id, is(6));
        assertThat(trueValue, is(true));
        assertThat(nullObject, nullValue());
        assertThat(msg, both(startsWith("Hello")).and(endsWith("World")));
    }
}
