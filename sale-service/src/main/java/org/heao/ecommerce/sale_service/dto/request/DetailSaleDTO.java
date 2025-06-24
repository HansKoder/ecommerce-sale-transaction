package org.heao.ecommerce.sale_service.dto.request;

public record DetailSaleDTO (
    ProductDTO product,
    int quantity
) { }
