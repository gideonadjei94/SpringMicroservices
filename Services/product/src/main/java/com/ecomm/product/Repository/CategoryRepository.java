package com.ecomm.product.Repository;

import com.ecomm.product.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {


    Category findByName(String s);

    boolean existsByName(String name);
}
