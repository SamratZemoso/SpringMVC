package com.application.aopdemo.dao;

import com.application.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;

    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + " adding an Account");

    }

    public void doSomeWork() {

        System.out.println("Another method with Work !!");

    }

    public List<Account> findAccounts(boolean flagEx) {

        if(flagEx) {
            throw new RuntimeException("Exception !");
        }

        List<Account> accounts = new ArrayList<>();

        // create some accounts
        Account tmp1 = new Account("John", "Beginner");
        Account tmp2 = new Account("Mary", "Intermediate");

        // add accounts to list
        accounts.add(tmp1);
        accounts.add(tmp2);

        // return list of accounts
        return accounts;
    }

    public String getName() {
        System.out.println("getter");
        return name;
    }

    public void setName(String name) {
        System.out.println("setter");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("getter");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("setter");
        this.serviceCode = serviceCode;
    }
}
