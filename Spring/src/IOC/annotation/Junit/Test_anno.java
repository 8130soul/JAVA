package IOC.annotation.Junit;

import IOC.annotation.config.Config;
import IOC.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_anno {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("IOC\\annotation\\Context.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
