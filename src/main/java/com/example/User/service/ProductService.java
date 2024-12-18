package com.example.User.service;

import com.example.User.models.Product;
import com.example.User.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    public ProductRepository repository;
    public List<Product> getAllProduct(){
        return  repository.findAll();
    }
    public String insertProduct(Product product){
        repository.save(product);
        return "Saved...";
    }
    public String deleteProduct(long id){
        repository.deleteById(id);
        return "Deleted...";
    }
}
