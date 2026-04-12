package com.ProductCrud.demo.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@EqualsAndHashCode(of="productID")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private String productID;

    @Column(name = "productName")
    private String productName;

    @Column(name = "priceInCents")
    private Integer priceInCents;

    private Integer quantity;

    private String category;

    public String toString() {;
        return "Produto{" + "Name=" + productName + '\'' + ", priceInCents=" + priceInCents + '\'' + ", quantity=" + quantity + '\'' + ", category=" + category + "}";
    }

    public Product(ProductDTO DTO){
        this.productName = DTO.productName();
        this.priceInCents = DTO.priceInCents();
        this.quantity = DTO.quantity();
        this.category = DTO.category();
    }

}