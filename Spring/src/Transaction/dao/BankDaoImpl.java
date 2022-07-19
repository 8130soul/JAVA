package Transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankDaoImpl implements BankDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addBanking() {
        String sql = "update account set money= money-? where user = ?";
        jdbcTemplate.update(sql,100,"Lucy");
    }

    @Override
    public void reduceBanking() {
        String sql = "update account set money= money+? where user = ?";
        jdbcTemplate.update(sql,100,"Merry");
    }
}
