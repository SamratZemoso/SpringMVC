package com.example.ioc;

public class Airtel implements MobileNetwork {

    @Override
    public void calling() {
        System.out.println("Calling in Airtel");
    }

    @Override
    public void data() {
        System.out.println("Data in Airtel");
    }
}
