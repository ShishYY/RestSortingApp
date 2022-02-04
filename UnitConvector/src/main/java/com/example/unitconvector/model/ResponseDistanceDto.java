package com.example.unitconvector.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDistanceDto {

    private String unit;

    private float value;
}
