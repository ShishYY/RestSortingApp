package com.example.sortingdata.model;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Data
public class RequestObjectDto {

    private ConditionDto condition = new ConditionDto();

    private List<Map<String, Object>> data = new ArrayList<>();

}
