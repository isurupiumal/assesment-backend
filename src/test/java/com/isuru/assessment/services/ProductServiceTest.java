package com.isuru.assessment.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void calculatePriceLessThanCartonQuantity() {

        Double price = productService.getCalculatedPrice(Long.valueOf(1), 15);
        assertThat(price).isEqualTo(183.75);
    }

    @Test
    public void calculatePriceMoreThanCartonQuantity() {
        Double price = productService.getCalculatedPrice(Long.valueOf(1), 25);
        assertThat(price).isEqualTo(271.25);
    }
}
