package com.example.User.controller;

import com.example.User.models.Orders;
import com.example.User.service.OrdersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    public OrdersService service;
    @GetMapping
    public List<Orders> getAllOrders(){
        return service.getAllOrders();
    }
    @PostMapping
    public String save( @Valid @RequestBody Orders orders){
        return  service.insertOrders(orders);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id ){
        return service.deleteOrders(id);
    }
}
