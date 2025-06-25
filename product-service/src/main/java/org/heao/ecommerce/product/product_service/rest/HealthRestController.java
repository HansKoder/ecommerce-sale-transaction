package org.heao.ecommerce.product.product_service.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthRestController {

    @GetMapping("/")
    public ResponseEntity<String> healthcheck () {
        return ResponseEntity.ok("Service Up");
    }

}
