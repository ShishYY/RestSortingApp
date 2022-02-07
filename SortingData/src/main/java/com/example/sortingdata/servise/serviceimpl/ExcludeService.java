package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.ConditionDto;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class ExcludeService {

    public List<Map<String, Object>> excludeFromData(ConditionDto condition, List<Map<String, Object>> data) {
        List<Map<String,Object>> result = new ArrayList<>();
        for(Map<String,Object> exclude :condition.getExclude()){
            for(Map.Entry<String,Object> excludeEntry : exclude.entrySet()){
                for(Map<String,Object> dataMap : data ){
                    if(dataMap.containsKey(excludeEntry.getKey())){
                       Object value =  dataMap.get(excludeEntry.getKey());
                       if (value !=null && !value.equals(excludeEntry.getValue())){
                           result.add(dataMap);
                       }
                    }
                }
            }
        }
    return result;
    }
}
