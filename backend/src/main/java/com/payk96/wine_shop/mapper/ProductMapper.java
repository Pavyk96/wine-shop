package com.payk96.wine_shop.mapper;

import com.payk96.wine_shop.dto.ProductRequest;
import com.payk96.wine_shop.dto.ProductResponse;
import com.payk96.wine_shop.model.Product;

public class ProductMapper {
    public static Product toProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .weight(productRequest.getWeight())
                .description(productRequest.getDescription())
                .build();
    }

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .weight(product.getWeight())
                .description(product.getDescription())
                .build();
    }
}
