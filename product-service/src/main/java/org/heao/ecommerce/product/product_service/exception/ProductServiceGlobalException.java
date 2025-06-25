package org.heao.ecommerce.product.product_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductServiceGlobalException {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorAPI> productNotFound (ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorAPI(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

}
