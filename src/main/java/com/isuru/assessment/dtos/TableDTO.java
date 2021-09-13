package com.isuru.assessment.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TableDTO {
    private int unit;
    private Double penguinEar;
    private Double horseshoe;
}
