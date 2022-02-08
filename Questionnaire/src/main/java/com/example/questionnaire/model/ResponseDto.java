package com.example.questionnaire.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ResponseDto {

    private int pathNumber;

    List<Map<String,String>> result;

}
