package org.heao.ecommerce.sale_service.service;

import org.heao.ecommerce.sale_service.dto.request.CreateSaleRequest;
import org.heao.ecommerce.sale_service.dto.request.DetailSaleDTO;
import org.heao.ecommerce.sale_service.dto.response.SaleWasCreatedResponse;
import org.heao.ecommerce.sale_service.entity.DetailSale;
import org.heao.ecommerce.sale_service.entity.Product;
import org.heao.ecommerce.sale_service.entity.Sale;
import org.heao.ecommerce.sale_service.entity.Stock;
import org.heao.ecommerce.sale_service.exception.ItemsIsEmptyException;
import org.heao.ecommerce.sale_service.exception.ProductNotFoundException;
import org.heao.ecommerce.sale_service.exception.ProductPriceMustBePositiveException;
import org.heao.ecommerce.sale_service.exception.StockQuantityInvalidException;
import org.heao.ecommerce.sale_service.repository.DetailSaleRepository;
import org.heao.ecommerce.sale_service.repository.ProductRepository;
import org.heao.ecommerce.sale_service.repository.SaleRepository;
import org.heao.ecommerce.sale_service.repository.StockRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final SaleRepository saleRepository;
    private final DetailSaleRepository  detailSaleRepository;

    public SaleServiceImpl(ProductRepository productRepository, StockRepository stockRepository, SaleRepository saleRepository, DetailSaleRepository detailSaleRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.saleRepository = saleRepository;
        this.detailSaleRepository = detailSaleRepository;
    }

    private Product getProductById (Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty())
            throw new ProductNotFoundException("Product " + productId + " not found in the DB");

        return optionalProduct.get();
    }

    private void updateStock (Product product, int quantity) {
        if (quantity < 1)
            throw new StockQuantityInvalidException("Quantity Must be greater to zero");

        Stock stock = new Stock();
        stock.product = product;
        stock.quantity = quantity;
        stockRepository.save(stock);
    }

    private DetailSale addDetailSale (DetailSaleDTO detail, Sale saleEntity) {
        if (detail.product().price().intValue() < 1)
            throw new ProductPriceMustBePositiveException();

        BigDecimal subTotal = detail.product().price()
                .multiply(BigDecimal.valueOf(detail.quantity()));

        DetailSale detailSaleEntity = new DetailSale();
        detailSaleEntity.sale = saleEntity;
        detailSaleEntity.quantity = detail.quantity();
        detailSaleEntity.subtotal = subTotal;
        return detailSaleRepository.save(detailSaleEntity);
    }

    @Override
    public SaleWasCreatedResponse createSale(CreateSaleRequest request) {
        BigDecimal total = BigDecimal.ZERO;

        if (request.items().isEmpty())
            throw new ItemsIsEmptyException("Must have almost an item");

        Sale saleEntity = new Sale();
        saleEntity.customer = request.customer();
        saleEntity.total = total;
        saleRepository.save(saleEntity);

        for (DetailSaleDTO detail : request.items()) {
            Product product = getProductById(detail.product().productId());
            updateStock(product, detail.quantity());
            BigDecimal subTotal = addDetailSale(detail, saleEntity).subtotal;
            
            total = total.add(subTotal);
        }

        saleEntity.total = total;
        saleRepository.save(saleEntity);

        return new SaleWasCreatedResponse(saleEntity.id, "Sale was crated with Successfully");
    }
}
