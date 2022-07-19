package IOC.xml.service;

import IOC.xml.dao.UserDao;

public class UserService {

    //外部bean方式注入
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("这是service的add方法");
        //原始方式:创建对象
        /*UserDao userDao = new UserDaoImpl();
        userDao.update();*/
        userDao.update();
    }
}
