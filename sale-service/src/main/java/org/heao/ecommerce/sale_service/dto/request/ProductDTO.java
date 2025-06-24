package org.heao.ecommerce.sale_service.dto.request;

import java.math.BigDecimal;

public record ProductDTO (
        Long productId,
        BigDecimal price
) { }
