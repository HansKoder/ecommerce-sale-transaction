package org.heao.ecommerce.stock.stock_service.service;

import org.heao.ecommerce.stock.stock_service.dto.request.UpdateStockRequest;

public interface StockService {

    void subtractStock(UpdateStockRequest request);

}
