package com.example.User.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @NotBlank(message = "Product name is mandatory")
    @Size(min = 2,max = 20,message = "Product name must be between 2 to 20")
    private String name;
    @NotBlank(message = "Product description is mandatory")
    @Size(min = 2,max = 50,message = "Product description must be between 2 to 50")
    private String description;
    @NotBlank
    private String price;
    private int stock;
    private LocalDate createOn;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonBackReference(value = "category-product")
    private Category category;
 @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
 @JsonManagedReference(value = "product-cartItem")
    private List<CartItem> cartItem;


}
