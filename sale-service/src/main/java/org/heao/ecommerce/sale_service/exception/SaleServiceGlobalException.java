package org.heao.ecommerce.sale_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SaleServiceGlobalException {

    @ExceptionHandler(ItemsIsEmptyException.class)
    public ResponseEntity<ErrorAPI> itemsIsEmpty (ItemsIsEmptyException ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorAPI(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorAPI> productNotFound (ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorAPI(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

    @ExceptionHandler(StockQuantityInvalidException.class)
    public ResponseEntity<ErrorAPI> stockQuantityInvalid (StockQuantityInvalidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorAPI(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(ProductPriceMustBePositiveException.class)
    public ResponseEntity<ErrorAPI> productPriceMustBePositive (ProductPriceMustBePositiveException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorAPI(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

}
