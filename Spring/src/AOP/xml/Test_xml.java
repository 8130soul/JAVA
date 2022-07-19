package AOP.xml;

import AOP.annotation.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_xml {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("AOP\\xml\\bean.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }
}
