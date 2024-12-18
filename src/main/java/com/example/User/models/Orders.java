package com.example.User.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "CreateOn date is mandatory")
    @Past(message =  "CreateOn date is must be past")
    private LocalDate createOn;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference(value = "user-orders")
    private User user;
    @ManyToMany
    @JsonIgnoreProperties("orders")
    private List<Cart> cart;
    @ManyToMany(mappedBy = "orders")
    @JsonIgnoreProperties("orders")
    private Set<Address> address;


}
