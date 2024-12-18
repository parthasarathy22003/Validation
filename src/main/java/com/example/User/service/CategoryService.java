package com.example.User.service;

import com.example.User.models.Category;
import com.example.User.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    public CategoryRepository repository;

    public List<Category> getAllCategory(){
        return  repository.findAll();
    }
    public String insertCategory(Category category){
        repository.save(category);
        return "saved....";
    }
    public  String delete(long id){
        repository.deleteById(id);
        return "deleted...";
    }
}
