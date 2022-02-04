package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.RequestExcludeDataDto;
import com.example.sortingdata.model.ResponseObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExcludeService {

    public List<ResponseObject> exclude(RequestExcludeDataDto req, List<ResponseObject> resultList) {
        Boolean tempBoolean = req.getCondition().getExclude().stream().findAny().get().getDisabled();
        List<ResponseObject> removeList = new ArrayList<>();
        resultList.forEach(result->{
            if(result.getDisabled() == tempBoolean){
                removeList.add(result);
            }
        });
        removeList.forEach(resultList::remove) ;
        return resultList;
    }
}
