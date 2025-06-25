package org.heao.ecommerce.sale.sale_service.dto.request;

import java.math.BigDecimal;

public record ProductDTO (
        Long productId,
        BigDecimal price
) { }
