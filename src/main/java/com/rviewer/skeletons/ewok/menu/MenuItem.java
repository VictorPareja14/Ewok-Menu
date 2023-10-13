package com.rviewer.skeletons.ewok.menu;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuItem {
    private String name;
    private String description;
    private double price;
}
