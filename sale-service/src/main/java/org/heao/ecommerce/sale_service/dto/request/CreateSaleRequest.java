package org.heao.ecommerce.sale_service.dto.request;

import java.util.List;

public record CreateSaleRequest (
        String customer,
        List<DetailSaleDTO> items
) { }
