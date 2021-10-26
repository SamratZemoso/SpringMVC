package com.application.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.application.aopdemo.aspect.PointCutComboExpressions.forDAOPackageNoGetterSetter()")
    public void performAPIOperations() {
        System.out.println(" !--- Before the Api Operations ---! ");
    }

}
