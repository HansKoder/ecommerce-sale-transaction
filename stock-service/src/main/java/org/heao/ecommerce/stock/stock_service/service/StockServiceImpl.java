package org.heao.ecommerce.stock.stock_service.service;

import jakarta.transaction.Transactional;
import org.heao.ecommerce.stock.stock_service.dto.request.UpdateStockRequest;
import org.heao.ecommerce.stock.stock_service.entity.Stock;
import org.heao.ecommerce.stock.stock_service.exception.ProductWithoutStockException;
import org.heao.ecommerce.stock.stock_service.exception.QuantityMustBePositiveException;
import org.heao.ecommerce.stock.stock_service.exception.RunOutProductException;
import org.heao.ecommerce.stock.stock_service.exception.UpdateStockInvalidException;
import org.heao.ecommerce.stock.stock_service.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    private Stock existItemWithStock (UpdateStockRequest request) {
        return stockRepository.findByProductId(request.productId())
                .orElseThrow(() -> new ProductWithoutStockException(request.productId()));
    }

    private void checkItemIsRunOut (Stock stock) {
        if (stock.quantity == 0)
            throw new RunOutProductException(stock.productId);
    }

    private void calculateSubtractQuantity (Stock stock, int subtractQuantity) {
        int quantityUpdated = stock.quantity - subtractQuantity;
        if (quantityUpdated < 0) {
            String msg = String.format("The current quantity is %s, the quantity %s is greater",
                    stock.quantity, subtractQuantity);
            throw new UpdateStockInvalidException(msg);
        }

        stock.quantity = quantityUpdated;
    }

    @Transactional
    @Override
    public void subtractStock(UpdateStockRequest request) {
        if (request.quantity() < 1)
            throw new QuantityMustBePositiveException();

        Stock entity = existItemWithStock(request);
        checkItemIsRunOut(entity);
        calculateSubtractQuantity(entity, request.quantity());

        stockRepository.save(entity);
    }
}
