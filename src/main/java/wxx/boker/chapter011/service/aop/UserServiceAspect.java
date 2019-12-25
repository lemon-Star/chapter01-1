package wxx.boker.chapter011.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Aspect 表明这是一个切面类
 * @Pointcut 表明这是一个切入点 exception 中的第一个*表示方法返回任意值  第二个*表明该包下的任意类,第三个*表明类中的任意方法,
 *            括号中的两个点表示方法中的任意参数,这里描述的切点是该包下所有类的所有方法
 *
 * @Before 前置通知,该方法在目标方法执行之前执行
 * @After 后置通知,该方法在目标方法执行之后执行
 * @AfterReturning 返回通知,可以获取目标方法的返回值 注解的returning参数是指返回值的变量名
 *
 *
 *
 */
@Component
@Aspect
@Slf4j
public class UserServiceAspect {
    @Pointcut("execution(* wxx.boker.chapter011.service.*.*(..))")
    public void pc1(){
    }

    @Before(value = "pc1()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info(name +"---this is pc1 before  方法开始执行");
    }

    @After(value="pc1()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        log.info(name + "----> this is after 执行结束");
    }

    @AfterReturning(value = "pc1()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name = joinPoint.getSignature().getName();
        log.info(name+"----> afterReturning ---"+ result);
    }

    @AfterThrowing(value = "pc1()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint , Exception e){
        String name = joinPoint.getSignature().getName();
        log.info(name+"----> afterReturning ---"+ e);
    }

    @Around(value = "pc1()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        return proceedingJoinPoint.proceed();
    }

}

