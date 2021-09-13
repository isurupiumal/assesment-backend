package com.isuru.assessment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private Long id;
    private String name;
    private Integer unitPerCarton;
    private Double cartonPrice;
    private String imageUrl;
    private Short rare;
    private Integer discountType;
}
