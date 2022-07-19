package IOC.xml.test;

import IOC.xml.autowire.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_auto {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("auto.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
