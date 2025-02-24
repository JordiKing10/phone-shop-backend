package com.phoneshop.config;

import com.phoneshop.port.out.ProductClientPort;
import com.phoneshop.adapter.out.client.ProductClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ProductClientPort productClientPort(ProductClient productClient) {
        return productClient;
    }
}
