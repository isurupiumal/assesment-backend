package com.isuru.assessment.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "discount",schema = "99xassesment")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "percentage")
    private Double percentage;

    @Column(name = "minimum_carton")
    private Integer minimumCarton;

    @Column(name = "labor_fee")
    private Double laborfee;
}
