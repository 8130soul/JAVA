package AOP.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//增强类
@Component
@Aspect
@Order(3)
public class UserProxy {

    //相同切入点抽取
    @Pointcut(value = "execution(* AOP.annotation.User.*(..))")
    public void cutpoint(){

    }

    //前置通知
    @Before(value = "cutpoint()")
    public void before(){
        System.out.println("before方法");
    }

    //最终通知
    @After(value = "execution(* AOP.annotation.User.*(..))")
    public void after(){
        System.out.println("after方法");
    }

    //异常通知
    @AfterThrowing(value = "execution(* AOP.annotation.User.*(..))")
    public void exception(){
        System.out.println("exception方法");
    }

    //环绕通知
    @Around(value = "execution(* AOP.annotation.User.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕之前");
        //被增强的方法
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后");
    }

    //后置通知
    @AfterReturning(value = "execution(* AOP.annotation.User.*(..))")
    public void AfterReturning(){
        System.out.println("AfterReturning方法");
    }
}
