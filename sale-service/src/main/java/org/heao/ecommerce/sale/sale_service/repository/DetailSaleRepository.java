package org.heao.ecommerce.sale.sale_service.repository;

import org.heao.ecommerce.sale.sale_service.entity.DetailSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailSaleRepository extends JpaRepository<DetailSale, Long> {
}
