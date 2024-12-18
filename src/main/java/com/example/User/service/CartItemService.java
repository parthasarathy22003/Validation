package com.example.User.service;

import com.example.User.models.CartItem;
import com.example.User.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    public CartItemRepository repository;
    public List<CartItem> getAllCartItem(){
        return  repository.findAll();
    }
    public String insertCartItem(CartItem cartItem){
        repository.save(cartItem);
        return "saved..";
    }
    public String deleteCartItem(long id){
        repository.deleteById(id);
        return "deleted..";
    }
}
