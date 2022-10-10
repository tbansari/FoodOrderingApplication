package com.foodOrder.momos.Controller;

import com.foodOrder.momos.Model.Dishes;
import com.foodOrder.momos.Repo.DishesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishesController {

    @Autowired
    private DishesRepo dishesRepo;

    @GetMapping(value="/dishes")
    public List<Dishes> getDishes() throws Exception{
        try {
            return dishesRepo.findAll();
        }
        catch (Exception ex){
            String msg = "Something went wrong. Please try again.";
            ex.printStackTrace();
            return null;
        }
    }

    @PostMapping(value="/saveDishes")
    public String saveDishes(@RequestBody Dishes dishes) throws Exception {
        try {
            dishesRepo.save(dishes);
            return "Saved Dish Successfully !";
        }
        catch(Exception ex){
            String msg = "Invalid input. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }

    @PutMapping(value="/updateDishes/{id}")
    public String updateDishes(@PathVariable long id, @RequestBody Dishes dishes) throws Exception {
        try {
            Dishes updateDishes = dishesRepo.findById(id).get();
            updateDishes.setDishName(dishes.getDishName());
            updateDishes.setDishType(dishes.getDishType());
            updateDishes.setAmount(dishes.getAmount());
            dishesRepo.save(updateDishes);
            return "Updated Dish Successfully !";
        }
        catch(Exception ex){
            String msg = "Invalid input. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }

    @DeleteMapping(value="/deleteDishes/{id}")
    public String deleteDishes(@PathVariable long id) throws Exception {
        try {
            Dishes updateDishes = dishesRepo.findById(id).get();
            updateDishes.setIsDeleted(true);
            dishesRepo.save(updateDishes);
            return "Deleted Dish Successfully !";
        }
        catch(Exception ex){
            String msg = "Cannot delete record. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }
}
