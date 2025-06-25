package org.heao.ecommerce.sale.sale_service.exception;

public class ItemsIsEmptyException extends RuntimeException{
    public ItemsIsEmptyException(String message) {
        super(message);
    }
}
