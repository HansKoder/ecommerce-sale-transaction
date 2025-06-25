package org.heao.ecommerce.sale.sale_service.product;

import org.heao.ecommerce.sale.sale_service.dto.response.ProductResponse;
import org.heao.ecommerce.sale.sale_service.entity.Product;
import org.heao.ecommerce.sale.sale_service.exception.InternalErrorException;
import org.heao.ecommerce.sale.sale_service.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ProductClientImpl implements ProductClient {
    private final WebClient webClient;

    public ProductClientImpl(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://localhost:9080")
                .build();
    }

    public ProductResponse getProductById (Long productId) {
        return webClient.get()
                .uri("/api/v1/products/" + productId)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                    if (clientResponse.statusCode() == HttpStatus.NOT_FOUND)
                        return Mono.error(new ProductNotFoundException("Product " + productId + " not found in the DB"));

                    return Mono.error(new InternalErrorException("Unexpected error client"));
                })
                .bodyToMono(ProductResponse.class)
                .block();
    }
}
