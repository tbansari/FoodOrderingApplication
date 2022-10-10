package com.foodOrder.momos.Controller;

import com.foodOrder.momos.Model.User;
import com.foodOrder.momos.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(path = "/")
    public String getPage(){
        return "Welcome to Momo's Food Ordering Application  !!!";
    }

    @GetMapping(path="/users")
    public List<User> getUsers() throws Exception{
        try {
            return userRepo.findAll();
        }
        catch (Exception ex){
            String msg = "Something went wrong. Please try again.";
            ex.printStackTrace();
            return null;
        }
    }

    @PostMapping(value="/save")
    public String saveUser(@RequestBody User user) throws Exception {
        try {
            userRepo.save(user);
            return "Saved User Successfully !";
        }
        catch(Exception ex){
            String msg = "Invalid input. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) throws Exception {
        try {
            User updateUser = userRepo.findById(id).get();
            updateUser.setFirstName(user.getFirstName());
            updateUser.setLastName(user.getLastName());
            updateUser.setPhone(user.getPhone());
            updateUser.setEmail(user.getEmail());
            updateUser.setAddress(user.getAddress());
            userRepo.save(updateUser);
            return "Updated User Successfully !";
        }
        catch(Exception ex){
            String msg = "Invalid input. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable long id) throws Exception {
        try {
            User updateUser = userRepo.findById(id).get();
            updateUser.setIsDeleted(true);
            userRepo.save(updateUser);
            return "Deleted User Successfully !";
        }
        catch(Exception ex){
            String msg = "Cannot delete record. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }
}
