package com.application.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogToCloudAspect {

    @Before("com.application.aopdemo.aspect.PointCutComboExpressions.forDAOPackageNoGetterSetter()")
    public void logToCloud() {
        System.out.println("!--- Before the Logging into cloud ---! ");
    }

}
