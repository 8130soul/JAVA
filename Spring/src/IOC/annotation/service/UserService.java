package IOC.annotation.service;

import IOC.annotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    /*@Autowired
    @Qualifier(value="userDao")
    private UserDao userDao;*/

    /*@Resource*/
    @Resource(name = "userDao")
    private UserDao userDao;

    @Value(value = "张三")
    private String str;

    public void add() {
        System.out.println("service add"+str);
        userDao.add();
    }
}
