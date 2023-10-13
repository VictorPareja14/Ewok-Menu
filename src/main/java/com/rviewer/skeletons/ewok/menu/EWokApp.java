package com.rviewer.skeletons.ewok.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EWokApp {
    @Autowired
    private EwokOrder ewokOrder;


    @PostConstruct
    public void start() {
        ewokOrder.placeOrder();
    }
}
