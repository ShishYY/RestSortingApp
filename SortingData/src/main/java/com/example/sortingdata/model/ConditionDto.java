package com.example.sortingdata.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class ConditionDto {
    @JsonProperty("sort_by")
    private List<String> sortBy;

    private List<Map<String, Object>> include;

    private List<Map<String, Object>> exclude;
}
