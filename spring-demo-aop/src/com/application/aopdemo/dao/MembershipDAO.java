package com.application.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addMember() {

        System.out.println("Membership class adding a Member !");

        return true;
    }

    public void renewMembership() {

        System.out.println("MemberShip renewed !!");

    }

}
