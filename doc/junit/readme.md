# Junit 单元测试
## 关于注解
1. @BeforeClass / @AfterClass：在所有测试方法执行之前 / 后执行，被注解的方法必须是public，static，无返回值，无参数；
2. @Before / @After：在每个测试方法执行之前 / 后执行，被注解的方法必须是public，无返回值，无参数；

```java
public class LoginActionTest {  
    private static LoginAction loginAction;  
    private static User user;  
  
    @BeforeClass  
    public static void init() {  
        loginAction = new LoginAction();  
        user = new User("haibin369", "123456");  
    }  
  
    @After  
    public void clearLoginUser() {  
        loginAction.getLoginUser().clear();  
    }  
  
    @Test  
    public void testLoginSuccess() throws Exception {  
        loginAction.login(user);  
  
        assertTrue("User didn't login!", loginAction.getLoginUser().contains(user));  
    }  
  
    @Test  
    public void testLogout() throws Exception {  
        loginAction.login(user);  
        loginAction.logout(user);  
  
        assertFalse("User didn't logout!", loginAction.getLoginUser().contains(user));  
    }  
}  
```