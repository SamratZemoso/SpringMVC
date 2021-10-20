package com.example.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam {

    public static void main(String[] args) {

        // Setter Injection
        ApplicationContext context = new ClassPathXmlApplicationContext("objectDI.xml");
//        Student s1 = context.getBean("abhi", Student.class);
//        s1.displayName();
//
//        Student s2 = context.getBean("ramesh", Student.class);
//        s2.displayName();

        // constructor Injection
//        Student s3 = context.getBean("rajesh", Student.class);
//        s3.displayName();

        Student studentOne = context.getBean("student", Student.class);
        studentOne.courseDetails();

        Student studentTwo = context.getBean("student", Student.class);
        studentTwo.courseDetails();

        // Bean Scope
        boolean check = (studentOne == studentTwo);

        System.out.println("Check the objects are same or not : " + check);

    }

}
