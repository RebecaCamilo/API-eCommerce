package com.loja.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User {
    @Id
    private String email;
    private String password;
    private String name;
    private boolean isAdmin;
}
