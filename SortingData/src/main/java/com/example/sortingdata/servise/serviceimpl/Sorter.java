package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.ConditionDto;
import com.example.sortingdata.model.ResponseDataDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Sorter {

    public ResponseDataDto sort(ConditionDto condition, Map<String,Object> data){
        ResponseDataDto response = new ResponseDataDto();

        return response;
    }
}
