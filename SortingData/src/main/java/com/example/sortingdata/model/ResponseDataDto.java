package com.example.sortingdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class ResponseDataDto {

    private List<Map<String, Object>> result;

}
