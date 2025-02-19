package com.payk96.wine_shop.service.impl;

import com.payk96.wine_shop.dto.ProductRequest;
import com.payk96.wine_shop.dto.ProductResponse;
import com.payk96.wine_shop.mapper.ProductMapper;
import com.payk96.wine_shop.model.Product;
import com.payk96.wine_shop.repository.ProductRepo;
import com.payk96.wine_shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public ProductResponse getProduct(UUID id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductMapper.toResponse(product);
    }

    @Override
    public ProductResponse updateProduct(UUID id, ProductRequest productRequest) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Product updatedProduct = ProductMapper.toProduct(productRequest);
        updatedProduct.setId(id);
        productRepo.save(updatedProduct);
        return ProductMapper.toResponse(updatedProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepo.findAll().stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = ProductMapper.toProduct(productRequest);
        productRepo.save(product);
        return ProductMapper.toResponse(product);
    }

    @Override
    public void deleteProduct(UUID id) {
        productRepo.deleteById(id);
    }
}
