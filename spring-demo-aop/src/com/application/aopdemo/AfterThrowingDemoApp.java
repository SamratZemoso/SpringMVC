package com.application.aopdemo;

import com.application.aopdemo.config.DemoConfig;
import com.application.aopdemo.dao.AccountDAO;
import com.application.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call method to find the accounts
        List<Account> accounts = null;

        try {
            boolean flagEx = true;
            accounts = accountDAO.findAccounts(flagEx);
        } catch (Exception ex) {
            System.out.println("Caught Exception : " + ex);
        }

        // display the accounts
        System.out.println(" After Throwing --> ");
        System.out.println(accounts);

        // close the context
        context.close();

    }

}
