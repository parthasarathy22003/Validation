package com.example.User.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "CreateOn date is mandatory")
    @Past(message =  "CreateOn date is must be past")
    private LocalDate createOn;
  @ManyToOne
  @JoinColumn(name = "product_id",referencedColumnName = "id")
  @JsonBackReference(value = "product-cartItem")
   private Product product;
    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "id")
 @JsonBackReference(value = "cartItem-cart")
    private Cart cart;

}
