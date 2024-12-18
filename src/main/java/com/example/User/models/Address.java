package com.example.User.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @NotBlank(message = "No is mandatory")
    @Size(min = 1,max = 5,message = "No must be between 1 to 5")
    private  String no;
    @NotBlank(message = "Street is mandatory")
    @Size(min = 2,max = 30,message = "Street name must be between 2 to 30")
    private  String street;
    @NotBlank(message = "City is mandatory")
    @Size(min = 2,max = 15,message = "City name must be between 2 to 15")
    private String city;
    @NotBlank(message = "State is mandatory")
    @Size(min = 2,max = 10,message = "State name must be between 2 to 10")
    private String state;
    @NotBlank(message = "Country is mandatory")
    @Size(min = 2,max = 10,message = "Country name must be between 2 to 10")
    private String country;
    @NotNull(message = "Create date is mandatory")
    @Past(message = "Created date is must be past date")
    private LocalDate createOn;
    private Type type;
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    @JsonBackReference(value = "user-address")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "order_address",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id")
    )
    @JsonIgnoreProperties("address")
    private Set<Orders> orders;

}
