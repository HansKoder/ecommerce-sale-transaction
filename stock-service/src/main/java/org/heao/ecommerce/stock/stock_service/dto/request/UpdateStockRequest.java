package org.heao.ecommerce.stock.stock_service.dto.request;

public record UpdateStockRequest(
        Long productId,
        int quantity
) { }
