package com.isuru.assessment.entities;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product",schema = "99xassesment")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "unit_per_carton")
    private Integer unitPerCarton;

    @Column(name = "carton_price")
    private Double cartonPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "rare")
    private Short rare;

    @Column(name = "discount_type")
    private Integer discountType;
}
