package com.example.User.controller;

import com.example.User.models.Product;
import com.example.User.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public ProductService service;
    @GetMapping
    public List<Product> getAllProduct(){
        return service.getAllProduct();
    }
    @PostMapping
    public String save(@Valid @RequestBody Product product){
        return  service.insertProduct(product);

    }
    @DeleteMapping("/{id}")
    public  String delete(@PathVariable long id){
        return service.deleteProduct(id);
    }

}
