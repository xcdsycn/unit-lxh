package com.lxh.unit.custommatcher;
/**
 * Created by lxh on 2018/1/21.
 */

import org.hamcrest.BaseMatcher;

/**
 * @author lxh
 * @Date 2018/1/21
 */
public class IsAdminMatcher extends BaseMatcher<User>{
    /**
     * 对给定的对象进行断言判定，返回true则断言成功，否则断言失败
     */
    @Override
    public boolean matches(Object item) {
        if (item == null) {
            return false;
        }

        User user = (User) item;
        return "admin".equals(user.getUserName()) && "admin".equals(user.getPassword());
    }

    @Override
    public void describeTo(org.hamcrest.Description description) {
        description.appendText("Administrator with 'admin' as username and password");
    }
}
