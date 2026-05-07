package com.guilherme.stockmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
//---------------------------------------------------------------------------------------
// Atruibutos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do poduto é obrigatório!")
    @Column(nullable = false)
    private String name;

    private String description;

    @NotNull(message = "O Preço é obrigatório!")
    @Min(value = 0, message = "O preço não pode ser negativo")
    @Column(nullable = false)
    private Double price;

    @NotNull(message = "A quantidade é obrigatória!")
    @Min(value = 0, message = "A quantidade não pode ser negativa")
    @Column(nullable = false)
    private Integer quantity;

    @NotNull(message = "A quantidade minima é obrigatória!")
    @Min(value = 0, message = "A quantidade minima não pode ser negativa")
    @Column(nullable = false)
    private Integer minimumQuantity;

    // Relacionamento com Category
    //ManyToOne = muitos produtos pertencem a uma categoria
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)// Nome da coluna no banco
    private Category category;

//---------------------------------------------------------------------------------------
// Construtor vazio — JPA exige

    public Product() {
    }

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

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMinimumQuantity() {
        return minimumQuantity;
    }
    public void setMinimumQuantity(int minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
