# Junit Test Rule
1. Rule是JUnit4中的新特性，它让我们可以扩展JUnit的功能，灵活地改变测试方法的行为。
2. JUnit中用@Rule和@ClassRule两个注解来实现Rule扩展，这两个注解需要放在实现了TestRule借口的成员变量（@Rule）或者静态变量（@ClassRule）上。
3. @Rule和@ClassRule的不同点是，@Rule是方法级别的，每个测试方法执行时都会调用被注解的Rule，而@ClassRule是类级别的，在执行一个测试类的时候只会调用一次被注解的Rule。
4. ExpectedException Rule

```java
class ExceptedExceptionRuleTest {
    //使用@Rule标记ExpectedException  
    @Rule  
    public ExpectedException expectedException = ExpectedException.none();  
      
    @Test  
    public void testAdminLogin2() throws ACLException, InterruptedException {  
        //期待抛出ACLException  
        expectedException.expect(ACLException.class);  
        //期待抛出的异常信息中包含"Access Denied"字符串  
        expectedException.expectMessage(CoreMatchers.containsString("Access Denied"));  
        //当然也可以直接传入字符串，表示期待的异常信息（完全匹配）  
        //expectedException.expectMessage("Access Denied!");  
          
        loginAction.login(new User("admin", "admin"));  
    }  
}
```
5. 设置全局超时时间

```java
class TimeOutRuleTest {
    //设置1000ms的超时时间，当超过这个时间测试还没执行完毕则失败  
    @Rule  
    public Timeout timeout = new Timeout(1000);  
      
    @Test  
    public void testLoginTimeout() throws Exception {  
        loginAction.login(new User("admin", "admin"));  
    }  

}
```