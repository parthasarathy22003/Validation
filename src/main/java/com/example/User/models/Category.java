package com.example.User.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @NotBlank(message = "Product name is mandatory")
    @Size(min = 2,max = 30 ,message = "Product name must be  between 2 to 30 ")
    private  String name;
    @NotBlank(message = "Product description is mandatory")
    @Size(min = 2,max = 50,message = "Product  description must be between 2 to 50 ")
    private  String description;
    @NotNull(message = "CreateOn is mandatory")
    @Past(message = "CreateOn date must be past date")
    private LocalDate createOn;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "category-product")
    private List<Product> products;


}
