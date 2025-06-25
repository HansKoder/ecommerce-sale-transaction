package org.heao.ecommerce.sale.sale_service.dto.request;

public record DetailSaleDTO (
    ProductDTO product,
    int quantity
) { }
