package com.example.ioc;

public class Jio implements MobileNetwork {
    @Override
    public void calling() {
        System.out.println("Calling in Jio");
    }

    @Override
    public void data() {
        System.out.println("Data in Jio");
    }
}
