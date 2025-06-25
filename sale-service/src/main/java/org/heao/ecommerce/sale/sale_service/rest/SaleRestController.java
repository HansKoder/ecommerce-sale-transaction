package org.heao.ecommerce.sale.sale_service.rest;

import org.heao.ecommerce.sale.sale_service.dto.request.CreateSaleRequest;
import org.heao.ecommerce.sale.sale_service.dto.response.CreateSaleResponse;
import org.heao.ecommerce.sale.sale_service.service.SaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sale")
public class SaleRestController {

    private final SaleService saleService;

    public SaleRestController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateSaleResponse> createSale (@RequestBody CreateSaleRequest request) {
        return ResponseEntity.ok(saleService.createSale(request));
    }

}
