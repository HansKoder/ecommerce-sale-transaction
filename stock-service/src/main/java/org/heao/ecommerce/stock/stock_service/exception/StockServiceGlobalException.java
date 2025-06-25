package org.heao.ecommerce.stock.stock_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StockServiceGlobalException {

    @ExceptionHandler(QuantityMustBePositiveException.class)
    public ResponseEntity<ErrorAPI> quantityMustBePositive (QuantityMustBePositiveException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorAPI(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(RunOutProductException.class)
    public ResponseEntity<ErrorAPI> runOutProduct (RunOutProductException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new ErrorAPI(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage()));
    }

    @ExceptionHandler(UpdateStockInvalidException.class)
    public ResponseEntity<ErrorAPI> updateStockInvalid (UpdateStockInvalidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorAPI(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(ProductWithoutStockException.class)
    public ResponseEntity<ErrorAPI> productWithoutStock (ProductWithoutStockException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorAPI(HttpStatus.NOT_FOUND.value(), ex.getMessage()));
    }

}
