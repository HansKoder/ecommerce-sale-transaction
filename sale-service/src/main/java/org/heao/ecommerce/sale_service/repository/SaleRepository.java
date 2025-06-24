package org.heao.ecommerce.sale_service.repository;

import org.heao.ecommerce.sale_service.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
