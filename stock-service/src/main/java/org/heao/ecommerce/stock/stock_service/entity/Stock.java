package org.heao.ecommerce.stock.stock_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "product_id")
    public Long productId;

    public int quantity;

    @Column(name = "created_at")
    public LocalDate createdAt;

}
