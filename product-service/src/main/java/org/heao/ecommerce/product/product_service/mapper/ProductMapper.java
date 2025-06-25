package org.heao.ecommerce.product.product_service.mapper;

import org.heao.ecommerce.product.product_service.dto.response.ProductResponse;
import org.heao.ecommerce.product.product_service.entity.Product;

public class ProductMapper {

    public static ProductResponse toDto (Product entity) {
        return new ProductResponse(entity.id, entity.productName, entity.productDescription);
    }

}
