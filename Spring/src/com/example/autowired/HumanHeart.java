package com.example.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HumanHeart {

    // Using before Dependency will not require setters,
    // Directly inject dependency byType
    @Autowired
    @Qualifier("humanHeart")

    private Heart heart;

    // Default constructor is needed when we use auto-wiring by constructor
//    public HumanHeart() {
//    }

//    @Autowired // Auto-wiring for Constructor
//    public HumanHeart(Heart heart) {
//        this.heart = heart;
//    }

    @Autowired
    @Qualifier("humanHeart")
    // Auto-wiring for Setter Method
    // Checks both byName and byType
    public void setHeart(Heart heart) {
        this.heart = heart;
    }

    public void checkHeart() {
        heart.pump();
    }

}
