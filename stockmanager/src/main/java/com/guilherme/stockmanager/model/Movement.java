package com.guilherme.stockmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "movements")
public class Movement {

// Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull(message = "O tipo de movimentação é obrigatório!")
    @Enumerated(EnumType.STRING)// Salva "ENTRADA" ou "SAIDA" no banco, não um número
    @Column(nullable = false)
    private MovementType type;

    @NotNull(message = "A quantidade é obridatória!")
    @Min(value = 1, message = "A quantidade deve ser pelo menos 1")
    @Column(nullable = false)
    private Integer quantity;

    private String reason;

    // Preenchido automáticamente - não vem do usuário
    @Column(nullable = false)
    private LocalDateTime date;

//---------------------------------------------------------------------------------------
// Construtor vazio — JPA exige

    public Movement() {
    }

//---------------------------------------------------------------------------------------
// Funções

    // Define a data automáticamente antes de salvar
    @PrePersist  //O @PrePersist É uma anotação do JPA (não do Spring em si) que diz: "execute esse metodo automaticamente antes de qualquer INSERT no banco."
                 // não é uma lógica de negócio — é uma instrução para o JPA sobre como persistir essa entidade. Por isso ele vive na própria entidade.
    private void prePersist(){
        this.date = LocalDateTime.now();
    }// O @PrePersist se encaixa nessa segunda parte: é uma regra de persistência, não de negócio.

//---------------------------------------------------------------------------------------
// Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public MovementType getType() {
        return type;
    }
    public void setType(MovementType type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
