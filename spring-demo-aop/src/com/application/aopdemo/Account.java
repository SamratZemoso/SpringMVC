package com.application.aopdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class Account {

    private @Getter @Setter
    String name;

    private @Getter @Setter
    String level;

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }
}
