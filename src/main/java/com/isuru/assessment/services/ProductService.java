package com.isuru.assessment.services;

import com.isuru.assessment.dtos.ProductDTO;
import com.isuru.assessment.dtos.TableDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();

    Double getCalculatedPrice(Long id, int quantity);

    List<TableDTO> getUnitPricesInTable();
}
