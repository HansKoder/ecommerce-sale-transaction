package org.heao.ecommerce.stock.stock_service.exception;

public class QuantityMustBePositiveException extends RuntimeException {
    public QuantityMustBePositiveException() {
        super("The quantity must be positive");
    }
}
