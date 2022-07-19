package IOC.xml.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import IOC.xml.pojo.Employee;
import IOC.xml.service.UserService;

public class Testbean {
    @Test
    //外部bean测试
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext2.xml");
        UserService userService = context.getBean("userService",UserService.class);
        userService.add();
    }

    @Test
    //内部bean测试
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext3.xml");
        Employee employee = context.getBean("employee", Employee.class);
        employee.test();
    }

    @Test
    //级联赋值
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext4.xml");
        Employee employee = context.getBean("employee", Employee.class);
        employee.test();
    }
}
