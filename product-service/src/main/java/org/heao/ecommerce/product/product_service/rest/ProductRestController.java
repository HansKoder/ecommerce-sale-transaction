package org.heao.ecommerce.product.product_service.rest;

import org.heao.ecommerce.product.product_service.dto.response.ProductResponse;
import org.heao.ecommerce.product.product_service.mapper.ProductMapper;
import org.heao.ecommerce.product.product_service.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById (@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(ProductMapper.toDto(productService.getProductById(productId)));
    }

}
