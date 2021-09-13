package com.isuru.assessment.controllers;

import com.isuru.assessment.dtos.ProductDTO;
import com.isuru.assessment.dtos.TableDTO;
import com.isuru.assessment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> data = productService.getAllProducts();
        return new ResponseEntity<List<ProductDTO>>(data, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/product/calculate")
    public ResponseEntity<Double> getCalculatedPrice(@RequestParam("id") Long id,
                                                           @RequestParam("quantity") int quantity){
        Double data = productService.getCalculatedPrice(id,quantity);
        return new ResponseEntity<Double>(data, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/product/units")
    public ResponseEntity<List<TableDTO>> getUnitPricesInTable(){
        List<TableDTO> data = productService.getUnitPricesInTable();
        return new ResponseEntity<List<TableDTO>>(data, new HttpHeaders(), HttpStatus.OK);
    }
}
