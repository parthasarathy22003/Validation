package com.example.User.service;

import com.example.User.models.Orders;
import com.example.User.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    @Autowired
    public OrdersRepository repository;
    public List<Orders> getAllOrders(){
        return  repository.findAll();
    }
    public  String insertOrders(Orders orders){
        repository.save(orders);
        return "saved";
    }
    public String deleteOrders(long id) {
        repository.deleteById(id);
return "deleted";
    }
}
