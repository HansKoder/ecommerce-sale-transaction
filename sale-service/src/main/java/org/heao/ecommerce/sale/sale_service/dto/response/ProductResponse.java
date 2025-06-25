package org.heao.ecommerce.sale.sale_service.dto.response;

public record ProductResponse(
    Long productId,
    String productName,
    String productDescription
) {
    @Override
    public String toString() {
        return "ProductResponse{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
