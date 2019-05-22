package com.gmail.kopandima.webshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static final class ProductBuilder {
        protected Integer id;
        protected String name;
        protected String description;
        protected BigDecimal price;

        private ProductBuilder() {
        }

        public static ProductBuilder aProduct() {
            return new ProductBuilder();
        }

        public ProductBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.id = this.id;
            return product;
        }
    }
}
