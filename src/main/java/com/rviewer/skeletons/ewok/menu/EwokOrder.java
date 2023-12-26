package com.rviewer.skeletons.ewok.menu;


import com.rviewer.skeletons.model.Customer;
import com.rviewer.skeletons.model.FoodOrder;
import com.rviewer.skeletons.repository.CustomerRepository;
import com.rviewer.skeletons.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Component
@Slf4j
public class EwokOrder {
    private final EWokMenu ewokMenu;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    public EwokOrder(EWokMenu ewokMenu) {
        this.ewokMenu = ewokMenu;
    }
    /*
    @Value("${api.orders.create.url}")
    private String createOrderApiUrl;
    */
    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String customerName = getCustomerName();
            int choice = getUserChoice();
            int quantity = getQuantity();
            int extraIngredientChoice = getExtraIngredientChoice();
            log.info("User {} registering order {}, {}, {}",customerName,choice,quantity,extraIngredientChoice);
            double total = calculateTotal(choice, quantity, extraIngredientChoice);
            System.out.println("Total to pay: " + total + " €");

            Customer customer = createOrGetCustomer(customerName);

            FoodOrder foodOrder = createFoodOrder(customer, choice, quantity, extraIngredientChoice);
            orderRepository.save(foodOrder);

            System.out.println("Order placed successfully!");
            log.info("Order placed successfully! {}",foodOrder.toString());
            System.out.print("¿Do you want to order something else (Y/N): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("y") && !answer.equals("yes")) {
                break; // Sale del bucle si la respuesta no es "y" o "yes"
            }
        }
    }

    private Customer createOrGetCustomer(String customerName) {
        Customer existingCustomer = customerRepository.findByUsername(customerName);

        if (existingCustomer != null) {
            log.info("User already registered {}",existingCustomer);
            return existingCustomer;
        } else {
            Customer newCustomer = new Customer();
            newCustomer.setUsername(customerName);
            newCustomer.setUuid(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
            log.info("New user registered successfully {}",newCustomer.toString());
            return customerRepository.save(newCustomer);
        }
    }

    private String getCustomerName() {
        System.out.print("Your name: ");
        return new Scanner(System.in).nextLine();
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

    private int getExtraIngredientChoice() {
        int extraIngredientChoice;
        do {
            System.out.print("Choose an extra ingredient for 1€ [(0) - None, (1) - Cherry tomato, (2) - Prawns, (3) - Pineapple]: ");
            extraIngredientChoice = new Scanner(System.in).nextInt();
        } while (extraIngredientChoice < 0 || extraIngredientChoice > 3);
        return extraIngredientChoice;
    }

    private double calculateTotal(int choice, int quantity, int extraIngredientChoice) {
        List<MenuItem> menuItems = ewokMenu.getMenuItems();
        double price = menuItems.get(choice - 1).getPrice();
        double extraIngredientCost = extraIngredientChoice * 1.0;
        return ((price + extraIngredientCost) * quantity);
    }

    private FoodOrder createFoodOrder(Customer customer, int choice, int quantity, int extraIngredientChoice) {
        FoodOrder foodOrder = new FoodOrder();

        foodOrder.setCustomer(customer);
        foodOrder.setUsername(customer.getUsername());
        foodOrder.setQuantity(quantity);
        foodOrder.setTotalToPay(calculateTotal(choice, quantity, extraIngredientChoice));
        foodOrder.setOrderDate(LocalDateTime.now());

        return foodOrder;
    }





}
