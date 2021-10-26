package com.application.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutComboExpressions {

    // To access this combo expressions,
    // in multiple aspects we create a separate aspect

    @Pointcut("execution(* com.application.aopdemo.dao.*.*(..))")
    public void forDAOPackage() {}

    // create a point cut for getter and setter methods
    @Pointcut("execution(* com.application.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.application.aopdemo.dao.*.set*(..))")
    public void setter() {}

    // create pointCut : Include package and exclude setter and getter
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter() {}


}
