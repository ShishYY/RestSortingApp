package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.ConditionDto;
import com.example.sortingdata.model.RequestObjectDto;
import com.example.sortingdata.model.ResponseDataDto;
import org.springframework.stereotype.Service;

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

    public ResponseDataDto parseAndSort(RequestObjectDto request){
        if(request != null){
            ConditionDto condition = request.getCondition();
            Map<String,Object> data = request.getData().stream().findAny().orElse(null);


            if(condition.getExclude() != null){
               data = excludeService.excludeFromData(condition,data);
               return sorter.sort(condition,data);
            }if(condition.getInclude() != null){


            }

        }
        return null;
    }


}
