package org.heao.ecommerce.sale_service.exception;

public class StockQuantityInvalidException extends RuntimeException {
    public StockQuantityInvalidException(String message) {
        super(message);
    }
}
