package org.heao.ecommerce.stock.stock_service.exception;

public class ProductWithoutStockException extends RuntimeException{
    public ProductWithoutStockException(Long productId) {
        super("This product with the ID " + productId + " does not have stock");
    }
}
