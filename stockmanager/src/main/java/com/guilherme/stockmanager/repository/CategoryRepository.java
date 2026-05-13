package com.guilherme.stockmanager.repository;

import com.guilherme.stockmanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // O Spring gera o SQL automáticamente pelo nome do metodo!!!
    // SELECT * FROM categories WHERE name = ?
    boolean existsByName(String name);
}
