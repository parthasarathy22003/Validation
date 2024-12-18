package com.example.User.controller;

import com.example.User.models.CartItem;
import com.example.User.service.CartItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
    @Autowired
    public CartItemService service;
    @GetMapping
    public List<CartItem> getAllCartItem(){
        return service.getAllCartItem();
    }
    @PostMapping
    public String save(@Valid @RequestBody CartItem cartItem){
        return service.insertCartItem(cartItem);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id ){
        return service.deleteCartItem(id);
    }


}
