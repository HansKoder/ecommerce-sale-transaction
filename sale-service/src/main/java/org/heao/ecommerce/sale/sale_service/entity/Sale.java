package org.heao.ecommerce.sale.sale_service.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public BigDecimal total;

    public String customer;

    @Column(name = "created_at")
    public LocalDate createdAt;

}
