package JUnit;

import Transaction.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //选择单元测试框架
@ContextConfiguration("classpath:transaction.xml")
public class JTest4 {
    @Autowired
    private BankService bankService;

    @Test
    public void test(){
        bankService.acc();
    }
}
