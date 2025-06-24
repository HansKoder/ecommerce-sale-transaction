package org.heao.ecommerce.sale_service.service;

import org.heao.ecommerce.sale_service.dto.request.CreateSaleRequest;
import org.heao.ecommerce.sale_service.dto.response.SaleWasCreatedResponse;

public interface SaleService {
    SaleWasCreatedResponse createSale (CreateSaleRequest request);
}
