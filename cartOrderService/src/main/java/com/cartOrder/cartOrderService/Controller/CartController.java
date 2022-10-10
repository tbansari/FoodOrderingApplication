package com.cartOrder.cartOrderService.Controller;

import com.cartOrder.cartOrderService.Modal.Cart;
import com.cartOrder.cartOrderService.Repo.CartRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping("/welcomeCart")
    public String getCartPage(){
        return "Welcome to Momo's Food Ordering Cart  !!!";
    }

    @GetMapping(value="/getCart")
    public List<Cart> getCart() throws Exception{
        try {
            return cartRepo.findAll();
        }
        catch (Exception ex){
            String msg = "Something went wrong. Please try again.";
            ex.printStackTrace();
            return null;
        }
    }


    @PostMapping(value="/saveCart")
    public String saveCartOrderByUserId(@RequestBody Cart cart) throws Exception {
        try {
            cartRepo.save(cart);
            return "Saved Cart Order Successfully !";
        }
        catch(Exception ex){
            String msg = "Invalid input. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }

    @PutMapping(value="/updateCart/{id}")
    public String updateCartOrderByUserId(@PathVariable long id, @RequestBody Cart cart) throws Exception {
        try {
            Cart updateCart = cartRepo.findById(id).get();
            updateCart.setDishId(cart.getDishId());
            updateCart.setUserId(cart.getUserId());
            updateCart.setQuantity(cart.getQuantity());
            cartRepo.save(updateCart);
            return "Updated Cart Order Successfully !";
        }
        catch(Exception ex){
            String msg = "Invalid input. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }

    @DeleteMapping(value="/deleteCart/{id}")
    public String deleteCartOrderById(@PathVariable long id) throws Exception {
        try {
            Cart updateCart = cartRepo.findById(id).get();
            updateCart.setIsDeleted(true);
            cartRepo.save(updateCart);
            return "Deleted Cart Order Successfully !";
        }
        catch(Exception ex){
            String msg = "Cannot delete record. Please try again.";
            ex.printStackTrace();
            return msg;
        }
    }

    @GetMapping(value="/getCartByUserId/{userId}")
    public List<Cart> getCartDetailsByUserId(@PathVariable long userId) throws Exception{
        try {
            return cartRepo.findCartByUser(userId);

//            Cart updateCart = cartRepo.findById(userId).get();
//            return (List<Cart>) updateCart;

//            List<Cart> cartList = new ArrayList<>();ArrayList
//            Session currentSession = sessionFactory.getCurrentSession();
//            Query query = currentSession.createQuery("select c from cart_tbl c " + " where c.user_id = 5 ");
//            query.setParameter("userId", userId);
//            cartList.addAll((Collection<? extends Cart>) ((org.hibernate.query.Query<?>) query).list());
//            return CollectionUtils.isEmpty(cartList) ? null : (List<Cart>) cartList.get(0);
        }
        catch (Exception ex){
            String msg = "Something went wrong. Please try again.";
            ex.printStackTrace();
            return null;
        }
    }
}
