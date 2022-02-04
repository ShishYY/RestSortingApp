package com.example.unitconvector.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestDto {

    private Distance distance;

    @JsonProperty("convert_to")
    private String parameter;


    @Data
    public static class Distance{

        private String unit;

        private float value;

    }

}
