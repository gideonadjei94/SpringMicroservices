package com.gideon.ecommerce.product.Models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Validated
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private double quantity;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
