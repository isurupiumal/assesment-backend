package com.isuru.assessment.mappers;

import com.isuru.assessment.dtos.ProductDTO;
import com.isuru.assessment.entities.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "unitPerCarton", target = "unitPerCarton"),
            @Mapping(source = "cartonPrice", target = "cartonPrice" ,numberFormat = "#.00"),
            @Mapping(source = "imageUrl", target = "imageUrl"),
            @Mapping(source = "rare", target = "rare"),
            @Mapping(source = "discountType", target = "discountType")
    })
    ProductDTO entityToDTO(Product product);

    @InheritInverseConfiguration
    Product dtoToEntity(ProductDTO productDTO);
}
