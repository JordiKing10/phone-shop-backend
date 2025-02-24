package com.phoneshop.adapter.in.rest;

import com.phoneshop.application.service.SimilarProductService;
import com.phoneshop.domain.model.Product;
import com.phoneshop.domain.exception.ProductNotFoundException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class SimilarProductController {
    private final SimilarProductService similarProductService;

    public SimilarProductController(SimilarProductService similarProductService) {
        this.similarProductService = similarProductService;
    }

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<Product>> getSimilarProducts(@PathVariable String productId) {
        List<Product> products = similarProductService.getSimilarProducts(productId);
        return ResponseEntity.ok(products);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Void> handleNotFound(ProductNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
}
