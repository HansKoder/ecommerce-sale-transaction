package org.heao.ecommerce.sale_service.exception;

public class ItemsIsEmptyException extends RuntimeException{
    public ItemsIsEmptyException(String message) {
        super(message);
    }
}
