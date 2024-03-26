package com.loja.ecommerce.model;

import jakarta.persistence.Table; // maybe the wrong import 8m46
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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
