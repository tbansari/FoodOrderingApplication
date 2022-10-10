package com.foodOrder.momos.Repo;

import com.foodOrder.momos.Model.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishesRepo extends JpaRepository<Dishes, Long> {
}
