package IOC.xml.dao;

public class UserDaoImpl implements UserDao{
    @Override
    public void update() {
        System.out.println("这是userDao的update方法");
    }
}
