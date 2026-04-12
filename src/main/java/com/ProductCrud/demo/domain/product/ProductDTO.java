package com.ProductCrud.demo.domain.product;

public record ProductDTO(String productName, Integer priceInCents, Integer quantity, String category) {}