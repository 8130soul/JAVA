package Transaction.test;

//import Transaction.Configure.MyConfig;
import Transaction.service.BankService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Tran {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("transaction.xml");
        BankService bankService = context.getBean("bankService", BankService.class);
        bankService.acc();
    }

    /*@Test
    public void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        BankService bankService = context.getBean("bankService", BankService.class);
        bankService.acc();
    }*/
}
