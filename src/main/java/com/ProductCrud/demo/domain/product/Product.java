package com.ProductCrud.demo.domain.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@EqualsAndHashCode(of="product_ID")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private String product_ID;

    private String product_name;

    private Integer price_in_cents;

    private Integer quantity;

    private String category;

    public String toString() {;
        return "Produto{" + "product_name=" + product_name + '\'' + ", price_in_cents=" + price_in_cents + '\'' + ", quantity=" + quantity + '\'' + ", category=" + category + "}";
    }

    public Product(ProductDTO DTO){
        this.product_name = DTO.product_name();
        this.price_in_cents = DTO.price_in_cents();
        this.quantity = DTO.quantity();
        this.category = DTO.category();
    }

}