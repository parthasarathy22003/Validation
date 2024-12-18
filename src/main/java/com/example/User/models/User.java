package com.example.User.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2,max = 30,message = "Name must be between 2 and 30 characters")
    private String name;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String Email;
    @NotBlank(message = "Number is mandatory")
    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",message = "Number must be a valid 10 digit phone number ")
    private String number;
    @NotBlank(message = "Pass word is mandatory")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;\"'<>,.?~`-])[A-Za-z\\d!@#$%^&*()_+{}\\[\\]:;\"'<>,.?~`-]{8,}$",message = "Pass word must be 8 ,atleast one special character,number and uppercase")
    private String password;
    @NotNull(message = "Date of birth is mandatory")
    @Past(message = "Date of birth must be a pat date")
    private LocalDate createOn;
    private Roles roles;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-address")
    private List<Address> address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "user-orders")
    private List<Orders> orders;

}