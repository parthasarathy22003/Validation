package com.example.User.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "CreateOn date is mandatory")
    @Past(message = "CreateOn date is must be past")
    private LocalDate createOn;

    @OneToOne
    private User user;
    @ManyToOne
    @JsonBackReference(value = "cartItem-cart")
    private CartItem cartItem;


}
