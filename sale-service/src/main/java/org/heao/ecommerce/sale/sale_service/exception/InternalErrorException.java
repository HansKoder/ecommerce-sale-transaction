package org.heao.ecommerce.sale.sale_service.exception;

public class InternalErrorException extends RuntimeException{
    public InternalErrorException(String message) {
        super(message);
    }
}
