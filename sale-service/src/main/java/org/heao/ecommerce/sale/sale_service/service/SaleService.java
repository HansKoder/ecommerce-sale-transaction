package org.heao.ecommerce.sale.sale_service.service;

import org.heao.ecommerce.sale.sale_service.dto.request.CreateSaleRequest;
import org.heao.ecommerce.sale.sale_service.dto.response.CreateSaleResponse;

public interface SaleService {
    CreateSaleResponse createSale (CreateSaleRequest request);
}
