package com.rviewer.skeletons.repository;
import com.rviewer.skeletons.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<FoodOrder, Long> {
    List<FoodOrder> findByUsername(String username);
}