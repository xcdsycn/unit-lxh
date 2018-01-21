package com.lxh.unit.custommatcher;
/**
 * Created by lxh on 2018/1/21.
 */

import org.hamcrest.Matcher;

/**
 * @author lxh
 * @Date 2018/1/21
 */
public class MyMatchers {
    public static Matcher<User> isAdmin() {
        return new IsAdminMatcher();
    }
}
