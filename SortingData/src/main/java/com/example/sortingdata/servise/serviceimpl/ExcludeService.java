package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.ConditionDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ExcludeService  {

    public Map<String,Object> excludeFromData(ConditionDto condition,Map<String,Object> data){


        return data;

    }

}
