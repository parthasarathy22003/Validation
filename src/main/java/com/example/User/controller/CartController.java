package com.example.User.controller;

import com.example.User.models.Cart;
import com.example.User.service.CartService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    public CartService service;
    @GetMapping
    public List<Cart> getAllCart(){
        return service.getAllCart();
    }
    @PostMapping
    public String save(@Valid @RequestBody Cart cart){
        return  service.insertCart(cart);

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        return  service.delete(id);
    }
}
