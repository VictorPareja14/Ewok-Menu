package com.rviewer.skeletons.ewok.menu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
@AllArgsConstructor
public class EWokMenu {
    private List<MenuItem> menuItems;

    public EWokMenu() {
        menuItems = new ArrayList<>();
        // Agrega elementos al menú
        menuItems.add(new MenuItem("Wok Wokling", "small size (noodles, calamari, shitake, sweet and sour sauce)", 4.0));
        menuItems.add(new MenuItem("Wok Wicket", "(noodles, beef, bacon, green beans, hot sauce)", 6.0));
        menuItems.add(new MenuItem("Wok Endor", "(rice, chicken breast, red and green pepper, curry sauce)", 7.0));
        menuItems.add(new MenuItem("Wok Kneesaa", "(rice, broccoli, mushrooms, corn, yakisoba sauce)", 6.0));

    }
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    public void displayMenu() {
        System.out.println("E-wok menu:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println("(" + (i + 1) + ") " + menuItems.get(i));
        }
    }
}
