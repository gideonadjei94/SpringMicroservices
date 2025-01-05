package com.gideon.ecommerce.product.Repository;

import com.gideon.ecommerce.product.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
