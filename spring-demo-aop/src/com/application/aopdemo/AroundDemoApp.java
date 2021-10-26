package com.application.aopdemo;

import com.application.aopdemo.config.DemoConfig;
import com.application.aopdemo.dao.AccountDAO;
import com.application.aopdemo.dao.MembershipDAO;
import com.application.aopdemo.service.FortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        FortuneService fortuneService = context.getBean("fortuneService", FortuneService.class);

        // calling fortune service ..
        String data = fortuneService.getFortune();

        System.out.println("fortune data : " + data);

        // close the context
        context.close();

    }

}
