package org.heao.ecommerce.product.product_service.service;

import org.heao.ecommerce.product.product_service.entity.Product;
import org.heao.ecommerce.product.product_service.exception.ProductNotFoundException;
import org.heao.ecommerce.product.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty())
            throw new ProductNotFoundException("Product " + id + " not found in the DB");

        return optionalProduct.get();
    }
}
