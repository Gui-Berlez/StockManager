package com.guilherme.stockmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categories") //Nome da tabela no banco
public class Category {
//---------------------------------------------------------------------------------------
// Atruibutos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento
    private Long id;

    @NotBlank(message = "O nome da categoria é obrigatório")
    @Column(nullable = false, unique = true) //Não pode ser NULO nem REPETIDO
    private String name;

    private String description;
//---------------------------------------------------------------------------------------
// Construtor vazio — o JPA exige isso para criar objetos

    public Category() {}

//---------------------------------------------------------------------------------------
// Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
