package Transaction.service;

import Transaction.dao.BankDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {

    @Autowired
    private BankDao bankDao;
    public void acc(){
        bankDao.addBanking();

        //异常
        int n = 100/0;

        bankDao.reduceBanking();
    }
}
