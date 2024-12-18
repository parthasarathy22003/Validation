package com.example.User.service;

import com.example.User.models.Address;
import com.example.User.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    public AddressRepository repository;
    public List<Address> getAllAddress(){
        return repository.findAll();
    }
    public String insertAddress(Address address){
        repository.save(address);
        return "Address saved...";
    }
    public String delete(long id){
        repository.deleteById(id);
        return "deleted...";
    }


}
