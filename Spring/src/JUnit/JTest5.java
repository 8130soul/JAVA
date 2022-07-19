package JUnit;


import Transaction.service.BankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:transaction.xml")*/
@SpringJUnitConfig(locations = "classpath:transaction.xml")
public class JTest5 {
    @Autowired
    private BankService bankService;

    @Test
    public void test(){
        bankService.acc();
    }
}
