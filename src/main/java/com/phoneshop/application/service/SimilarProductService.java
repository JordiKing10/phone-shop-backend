package com.phoneshop.application.service;

import com.phoneshop.domain.model.Product;
import com.phoneshop.port.out.ProductClientPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SimilarProductService {
    private final ProductClientPort productClient;

    public SimilarProductService(ProductClientPort productClient) {
        this.productClient = productClient;
    }

    public List<Product> getSimilarProducts(String productId) {
        List<String> similarIds = productClient.getSimilarProductIds(productId);
        return similarIds.stream().map(productClient::getProductById).toList();
    }
}
