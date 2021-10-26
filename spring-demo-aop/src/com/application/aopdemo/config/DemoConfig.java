package com.application.aopdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy // Spring AOP Proxy Support
@ComponentScan("com.application.aopdemo")
public class DemoConfig {

    // ...

}
