package org.heao.ecommerce.stock.stock_service.rest;

import org.heao.ecommerce.stock.stock_service.dto.request.UpdateStockRequest;
import org.heao.ecommerce.stock.stock_service.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockRestController {

    private final StockService service;

    public StockRestController(StockService service) {
        this.service = service;
    }

    @PutMapping("/subtract-stock")
    ResponseEntity<Void> updateStock (@RequestBody UpdateStockRequest request) {
        service.subtractStock(request);
        return ResponseEntity.noContent().build();
    }
}
