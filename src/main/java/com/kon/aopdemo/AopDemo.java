package com.kon.aopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Aspect
@Component
public class AopDemo {

    private static final Logger log = LoggerFactory.getLogger(AopDemo.class);
    private final String restPoint = "execution(* com.kon.aopdemo.UploadServ.recMap(..))";

    @Pointcut(restPoint)
    public void pointcut(){}

   /* @Before("pointcut()")
    public void doBeforeMethod(JoinPoint joinPoint){

        Object[] objs = joinPoint.getArgs();
        Map arg = (Map)objs[0];
        List<Map> list = (List)arg.get("datas");
        log.info(list.toString());

    }*/

    @AfterReturning(value = restPoint,returning = "result")
    public void doAfterReturningMethod(JoinPoint joinPoint,Object result){

        //获取参数
        Object[] objs = joinPoint.getArgs();
        Map arg = (Map)objs[0];
        List<Map> list = (List)arg.get("datas");
        log.info(list.toString());

        //获取返回值
        String re = (String)result;
        log.info(re);
    }


}
