package com.phoneshop.adapter.out.client;

import com.phoneshop.domain.model.Product;
import com.phoneshop.domain.exception.ProductNotFoundException;
import com.phoneshop.port.out.ProductClientPort;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@Component
public class ProductClient implements ProductClientPort {
    private final RestTemplate restTemplate;
    private final String baseUrl;

    public ProductClient(RestTemplate restTemplate, @Value("${external.api.url}") String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public List<String> getSimilarProductIds(String productId) {
        String url = String.format("%s/product/%s/similarids", baseUrl, productId);
        try {
            String[] ids = restTemplate.getForObject(url, String[].class);
            return Arrays.asList(ids);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new ProductNotFoundException("Product not found: " + productId);
        }
    }

    @Override
    public Product getProductById(String productId) {
        String url = String.format("%s/product/%s", baseUrl, productId);
        try {
            return restTemplate.getForObject(url, Product.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new ProductNotFoundException("Product not found: " + productId);
        }
    }
}
