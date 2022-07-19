package AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDK_Proxy {
    public static void main(String[] args) {
        //创建接口实现类的代理对象
        Class[] interfaces = {UserDao.class};

        UserDaoImpl userDao = new UserDaoImpl();
        UserDao UserDao = (AOP.UserDao) Proxy.newProxyInstance(JDK_Proxy.class.getClassLoader(), interfaces, new UserDao_proxy(userDao));
        System.out.println(userDao.add(1, 2));
        /*System.out.println("----");
        System.out.println(userDao.getClass().getClassLoader().toString());
        System.out.println(userDao.getClass().getInterfaces().toString());*/
    }
}

//创建代理对象
class UserDao_proxy implements InvocationHandler {

    //把被代理对象传递过来
    private Object object;

    public UserDao_proxy(Object o) {
        this.object = o;
    }

    //增强逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //before
        System.out.println("方法之前执行" + method.getName() + ":传递的参数" + Arrays.toString(args));

        //被增强的方法
        Object invoke = method.invoke(object, args);

        //after
        System.out.println("方法之后执行" + object);

        return invoke;
    }
}
