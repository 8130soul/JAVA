package AOP.annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class Proxy {
    //最终通知
    @After(value = "execution(* AOP.annotation.User.*(..))")
    public void after(){
        System.out.println("新的after方法");
    }
}
