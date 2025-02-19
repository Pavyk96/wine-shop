package com.payk96.wine_shop.service;

import com.payk96.wine_shop.dto.ProductRequest;
import com.payk96.wine_shop.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductResponse getProduct(UUID id);
    ProductResponse updateProduct(UUID id, ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
    ProductResponse createProduct(ProductRequest productRequest);
    void deleteProduct(UUID id);
}
