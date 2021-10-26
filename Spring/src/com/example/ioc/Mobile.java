package com.example.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

    public static void main(String[] args) {
//        MobileNetwork network = new Jio();
//        network.calling();
//        network.data();
//        This should be configurable such that we should not modify this class

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        MobileNetwork sim1 = (MobileNetwork) context.getBean("sim1");
        sim1.calling();
        sim1.data();

        MobileNetwork sim2 = context.getBean("sim2", MobileNetwork.class);
        sim2.calling();
        sim2.data();



    }

}
