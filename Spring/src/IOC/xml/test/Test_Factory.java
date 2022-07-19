package IOC.xml.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import IOC.xml.pojo.Student;

public class Test_Factory {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("FactoryBean.xml");
        Student student = context.getBean("factory", Student.class);
        Student student2 = context.getBean("factory", Student.class);
        System.out.println(student);
        System.out.println(student2);
    }
}
