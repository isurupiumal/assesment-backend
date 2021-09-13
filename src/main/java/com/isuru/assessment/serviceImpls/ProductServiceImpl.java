package com.isuru.assessment.serviceImpls;

import com.isuru.assessment.dtos.ProductDTO;
import com.isuru.assessment.dtos.TableDTO;
import com.isuru.assessment.entities.Discount;
import com.isuru.assessment.entities.Product;
import com.isuru.assessment.mappers.ProductMapper;
import com.isuru.assessment.repositories.DiscountRepository;
import com.isuru.assessment.repositories.ProductRepository;
import com.isuru.assessment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DiscountRepository discountRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product p :products){
            ProductDTO dto = ProductMapper.INSTANCE.entityToDTO(p);
            productDTOS.add(dto);
        }
        return productDTOS;
    }

    @Override
    public Double getCalculatedPrice(Long id, int quantity) {

        Double price = 0.0;
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Discount discount = discountRepository.findObjectById(product.get().getDiscountType());
            price = getTotalPrice(quantity,product.get(),discount);
        }
        return price;
    }

    @Override
    public List<TableDTO> getUnitPricesInTable() {
        List<TableDTO> tableDTOS = new ArrayList<>();
        Product penguinEar = productRepository.findObjectById((long)1);
        Product horseshoe = productRepository.findObjectById((long)2);
        Discount discount = discountRepository.findObjectById(penguinEar.getDiscountType());
        for(int i = 1;i<=50;i++){
            TableDTO dto = new TableDTO();
            dto.setUnit(i);
            dto.setPenguinEar(getTotalPrice(i,penguinEar,discount));
            dto.setHorseshoe(getTotalPrice(i,horseshoe,discount));
            tableDTOS.add(dto);
        }
        return tableDTOS;
    }

    private Double getTotalPrice(int quantity,Product product,Discount discount){
        Double price = 0.0;
        int carton = quantity / product.getUnitPerCarton();
        int units = quantity % product.getUnitPerCarton();
        Double cartoonPrice = product.getCartonPrice()* carton;
        Double unitPrice = getUnitPrice(units,product.getCartonPrice(),product.getUnitPerCarton(),
                discount.getLaborfee());
        price = cartoonPrice + unitPrice;
        if(carton >= discount.getMinimumCarton()){
            price = price - (price * discount.getPercentage()/100);
        }
        return price;
    }

    private Double getUnitPrice(int units,Double cartonPrice, int unitPerCarton,Double laborFee){
        return ((cartonPrice/unitPerCarton ) * units) + (cartonPrice *laborFee/100);
    }
}
