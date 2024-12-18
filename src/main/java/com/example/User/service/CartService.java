package com.example.User.service;

import com.example.User.models.Cart;
import com.example.User.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    public CartRepository repository;
    public List<Cart> getAllCart(){
        return  repository.findAll();
    }
    public  String insertCart(Cart cart){
        repository.save(cart);
        return "saved";
    }
    public String delete(long id){
        repository.deleteById(id);
        return  "deleted";
    }
}
