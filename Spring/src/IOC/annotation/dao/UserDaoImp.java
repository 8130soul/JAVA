package IOC.annotation.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImp implements UserDao{
    @Override
    public void add() {
        System.out.println("userDao的add方法");
    }
}
