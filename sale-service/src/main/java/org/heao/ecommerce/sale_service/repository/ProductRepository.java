package org.heao.ecommerce.sale_service.repository;

import org.heao.ecommerce.sale_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
