package com.rviewer.skeletons.ewok.menu;

import com.rviewer.skeletons.ewok.menu.EWokMenu;
import com.rviewer.skeletons.ewok.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class EwokOrder {
    @Autowired
    private  EWokMenu ewokMenu;

    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int quantity;

        ewokMenu.displayMenu();
        choice = getUserChoice();
        quantity = getQuantity();

        double total = calculateTotal(choice, quantity);
        System.out.println("Total to pay: " + total + " €");
    }

    private int getUserChoice() {
        int choice;
        do {
            System.out.print("Choose a wok from the menu (1 to 4): ");
            choice = new Scanner(System.in).nextInt();
        } while (choice < 1 || choice > 4);
        return choice;
    }

    private int getQuantity() {
        int quantity;
        do {
            System.out.print("Choose quantity (1 to 5): ");
            quantity = new Scanner(System.in).nextInt();
        } while (quantity < 1 || quantity > 5);
        return quantity;
    }

    private double calculateTotal(int choice, int quantity) {
        List<MenuItem> menuItems = ewokMenu.getMenuItems();
        // Suponiendo que el precio de los woks esté en el mismo orden que en el menú
        double price = menuItems.get(choice - 1).getPrice();
        return price * quantity;
    }
}