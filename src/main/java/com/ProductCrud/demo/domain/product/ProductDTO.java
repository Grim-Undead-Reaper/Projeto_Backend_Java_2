package com.ProductCrud.demo.domain.product;

public record ProductDTO(String product_name, Integer price_in_cents, Integer quantity, String category) {}