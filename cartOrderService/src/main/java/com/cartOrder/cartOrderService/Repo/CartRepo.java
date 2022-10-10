package com.cartOrder.cartOrderService.Repo;

import com.cartOrder.cartOrderService.Modal.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

//    @Query("select u from cartTbl u where u.user_id = userId")
//    @Query("select u From cartTbl u where u.user_id = :52")
//    List<Cart> findCartByUserId(long userId);

    @Query(value = "SELECT t.* from cart_tbl t WHERE t.user_id = :userId", nativeQuery = true)
    List<Cart> findCartByUser(long userId);
}
