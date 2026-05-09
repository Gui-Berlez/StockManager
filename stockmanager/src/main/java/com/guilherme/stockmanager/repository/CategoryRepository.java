package com.guilherme.stockmanager.repository;

import com.guilherme.stockmanager.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {



}
