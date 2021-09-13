package com.isuru.assessment.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isuru.assessment.dtos.ProductDTO;
import com.isuru.assessment.services.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMVC;

    @MockBean
    ProductService productService;

    @Test
    public void getAllProducts() throws Exception {
        ProductDTO product = new ProductDTO();
        product.setId(Long.valueOf(1));
        product.setName("Penguin-ears");
        product.setUnitPerCarton(20);
        product.setCartonPrice(175.00);
        product.setRare((short)1);
        product.setDiscountType(1);

        ProductDTO product2 = new ProductDTO();
        product2.setId(Long.valueOf(2));
        product2.setName("Horseshoe");
        product2.setUnitPerCarton(5);
        product2.setCartonPrice(825.00);
        product.setRare((short)0);
        product.setDiscountType(1);

        List<ProductDTO> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product2);

        Mockito.when(productService.getAllProducts()).thenReturn(productList);
        String uri = "/api/products";

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMVC.perform(requestBuilder).andReturn();

        String expected = this.mapToJson(productList);
        String actual = result.getResponse().getContentAsString();
        assertThat(actual).isEqualTo(expected);
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}
