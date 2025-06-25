package org.heao.ecommerce.stock.stock_service.mapper;

import org.heao.ecommerce.stock.stock_service.dto.request.UpdateStockRequest;
import org.heao.ecommerce.stock.stock_service.entity.Stock;

import java.util.Objects;

public class StockMapper {

    public static Stock toEntity (UpdateStockRequest request) {
        if (Objects.isNull(request))
            throw new IllegalArgumentException("Request Must be mandatory");

        Stock entity = new Stock();
        entity.productId = request.productId();
        entity.quantity = request.quantity();

        return entity;
    }
}
