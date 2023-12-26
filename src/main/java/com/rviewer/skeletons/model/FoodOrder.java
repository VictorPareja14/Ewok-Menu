package com.rviewer.skeletons.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    private String username;
    private String wokId;
    private String extraIngredientId;
    private int quantity;
    private double totalToPay;
    private LocalDateTime orderDate;
}
