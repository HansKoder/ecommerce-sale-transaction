package org.heao.ecommerce.sale.sale_service.product;

import org.heao.ecommerce.sale.sale_service.dto.response.ProductResponse;

public interface ProductClient {

    ProductResponse getProductById (Long id);

}
