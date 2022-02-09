package com.example.questionnaire.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseDto {

    private Integer pathNumber;

    List<Map<String,String>> result;

}
