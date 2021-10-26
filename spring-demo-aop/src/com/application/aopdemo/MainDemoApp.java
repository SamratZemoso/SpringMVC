package com.application.aopdemo;

import com.application.aopdemo.config.DemoConfig;
import com.application.aopdemo.dao.AccountDAO;
import com.application.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // create an object for Account Class
        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");

        // call the business method
        accountDAO.addAccount(account, true);
        accountDAO.doSomeWork();

        // calling setter and getter methods
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("FRTG");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        // call the membership methods
        membershipDAO.addMember();
        membershipDAO.renewMembership();

        // close the context
        context.close();

    }

}
