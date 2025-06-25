package org.heao.ecommerce.sale.sale_service.exception;

public class StockQuantityInvalidException extends RuntimeException {
    public StockQuantityInvalidException(String message) {
        super(message);
    }
}
