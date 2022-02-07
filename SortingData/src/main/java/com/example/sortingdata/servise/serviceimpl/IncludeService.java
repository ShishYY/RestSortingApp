package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.ConditionDto;
import com.example.sortingdata.model.ResponseDataDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class IncludeService {

    public List<Map<String, Object>> includeToData(ConditionDto condition, List<Map<String, Object>> data) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> include : condition.getInclude()) {
            for (Map.Entry<String, Object> includeEntry : include.entrySet()) {
                for (Map<String, Object> dataMap : data) {
                    if (dataMap.containsKey(includeEntry.getKey())) {
                        Object value = dataMap.get(includeEntry.getKey());
                        if (value != null && value.equals(includeEntry.getValue())) {
                            result.add(dataMap);
                        }
                    }
                }
            }
        }
        return result;
    }
}

