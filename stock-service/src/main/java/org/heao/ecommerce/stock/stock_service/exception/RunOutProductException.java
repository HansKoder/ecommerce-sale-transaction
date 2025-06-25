package org.heao.ecommerce.stock.stock_service.exception;

public class RunOutProductException extends RuntimeException{
    public RunOutProductException(Long productId) {
        super("Product with the ID " + productId + " is run out, this need to check and supply it");
    }
}
