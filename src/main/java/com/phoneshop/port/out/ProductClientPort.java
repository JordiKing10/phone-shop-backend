package com.phoneshop.port.out;

import com.phoneshop.domain.model.Product;
import java.util.List;

public interface ProductClientPort {
    List<String> getSimilarProductIds(String productId);
    Product getProductById(String productId);
}
