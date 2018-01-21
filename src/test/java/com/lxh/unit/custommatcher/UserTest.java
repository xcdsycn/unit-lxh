package com.lxh.unit.custommatcher;

import org.junit.Test;

import static com.lxh.unit.custommatcher.MyMatchers.isAdmin;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lxh on 2018/1/21.
 */
public class UserTest {
    User user = new User("haibin369", "123456");

    @Test
    public void testAdmin() throws Exception {
        assertThat(user, isAdmin());
    }
}