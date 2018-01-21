# Junit Test Rule
1. Rule是JUnit4中的新特性，它让我们可以扩展JUnit的功能，灵活地改变测试方法的行为。
2. JUnit中用@Rule和@ClassRule两个注解来实现Rule扩展，这两个注解需要放在实现了TestRule借口的成员变量（@Rule）或者静态变量（@ClassRule）上。
3. @Rule和@ClassRule的不同点是，@Rule是方法级别的，每个测试方法执行时都会调用被注解的Rule，而@ClassRule是类级别的，在执行一个测试类的时候只会调用一次被注解的Rule。