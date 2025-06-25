package org.heao.ecommerce.sale.sale_service.mapper;

import org.heao.ecommerce.sale.sale_service.dto.response.ProductResponse;
import org.heao.ecommerce.sale.sale_service.entity.Product;

import java.util.Objects;

public class ProductMapper {

    public static Product toEntity (ProductResponse dto) {
        if (Objects.isNull(dto)) throw new IllegalArgumentException("DTO Must be mandatory");

        Product entity = new Product();
        entity.id = dto.productId();
        entity.productName = dto.productName();
        entity.productDescription = dto.productDescription();

        return entity;
    }

}
