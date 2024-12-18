package com.example.User.controller;

import com.example.User.models.Category;
import com.example.User.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    public CategoryService service;
    @GetMapping
    public List<Category> getAllCategory(){
        return service.getAllCategory();
    }
    @PostMapping
    public String save(@Valid @RequestBody Category category){
        return  service.insertCategory(category);
    }
    @DeleteMapping("/{id}")
    public  String delete(long id){
        return  service.delete(id);
    }

}
