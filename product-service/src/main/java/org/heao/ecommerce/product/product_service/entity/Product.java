package org.heao.ecommerce.product.product_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "product_name")
    public String productName;

    @Column(name = "product_description")
    public String productDescription;

    @Column(name = "created_at")
    public LocalDate createdAt;

}
