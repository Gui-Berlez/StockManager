package com.guilherme.stockmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {

// Atruibutos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O username é obrigatório!")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "O email é obrigatório!")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "A senha é obridatória!")
    @Column(nullable = false)
    private String password;

    // Role define o que o usuário pode fazer
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

//---------------------------------------------------------------------------------------
// Construtor

    public User() {
    }

//---------------------------------------------------------------------------------------
// Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
