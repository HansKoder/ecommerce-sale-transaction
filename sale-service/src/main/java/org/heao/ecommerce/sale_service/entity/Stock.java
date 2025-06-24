package org.heao.ecommerce.sale_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "stocks")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    public Product product;

    public int quantity;

    @Column(name = "created_at")
    public LocalDate createdAt;

}
