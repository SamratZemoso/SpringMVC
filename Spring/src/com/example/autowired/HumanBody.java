package com.example.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HumanBody {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean-autowired.xml");
        HumanHeart human = context.getBean("human", HumanHeart.class);
        human.checkHeart();

    }
}
