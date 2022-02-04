package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.RequestExcludeDataDto;
import com.example.sortingdata.model.ResponseObject;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IncludeService {

    public List<ResponseObject> include(RequestExcludeDataDto req, List<ResponseObject> resultList){
        String sortParameter = req.getCondition().getInclude().stream().findAny().get().getParameter();
            resultList.forEach(result -> {
                resultList.stream().filter(x -> x.getUser().equals(sortParameter)).collect(Collectors.toList());
            });

        return resultList;
    }
}
