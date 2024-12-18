package com.example.User.controller;

import com.example.User.models.Address;
import com.example.User.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressS")
public class AddressController {
    @Autowired
    public AddressService service;
    @GetMapping
    public List<Address> getAllAddress(){
        return  service.getAllAddress();
    }
    @PostMapping
    public String save(@Valid @RequestBody Address address){
        return  service.insertAddress(address);
    }
    @DeleteMapping("/{id}")
    public  String delete(@PathVariable long id ){
        return  service.delete(id);
    }
}
