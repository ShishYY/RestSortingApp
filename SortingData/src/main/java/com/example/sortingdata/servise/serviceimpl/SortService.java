package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.ConditionDto;
import com.example.sortingdata.model.RequestObjectDto;
import com.example.sortingdata.model.ResponseDataDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SortService {

    private final Sorter sorter;
    private final ExcludeService excludeService;
    private final IncludeService includeService;

    public SortService(Sorter sorter, ExcludeService excludeService, IncludeService includeService) {
        this.sorter = sorter;
        this.excludeService = excludeService;
        this.includeService = includeService;
    }
//Main module
    public ResponseDataDto parseAndSort(RequestObjectDto request){
        if(request != null){
            ConditionDto condition = request.getCondition();
            if(condition.getExclude() != null){
                List<Map<String,Object>> data = excludeService.excludeFromData(condition,request.getData());
               return sorter.sort(condition,data);
            }if(condition.getInclude() != null){
               List<Map<String,Object>> data = includeService.includeToData(condition,request.getData());
                return sorter.sort(condition,data);
            }
        }
        throw new RuntimeException("Data from request incorrect");
    }


}
