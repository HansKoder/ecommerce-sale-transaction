package org.heao.ecommerce.sale_service.exception;

public class ProductPriceMustBePositiveException extends RuntimeException{
    public ProductPriceMustBePositiveException() {
        super("Product Price must be positive");
    }
}
