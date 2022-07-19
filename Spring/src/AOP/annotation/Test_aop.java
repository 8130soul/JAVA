package AOP.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_aop {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("AOP\\annotation\\anno.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
