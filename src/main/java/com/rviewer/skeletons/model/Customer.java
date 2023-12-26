package com.rviewer.skeletons.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(unique = true)
    private String uuid;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<FoodOrder> foodOrders;
}
