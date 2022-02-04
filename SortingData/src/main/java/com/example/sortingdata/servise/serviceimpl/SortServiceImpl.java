package com.example.sortingdata.servise.serviceimpl;

import com.example.sortingdata.model.RequestExcludeDataDto;
import com.example.sortingdata.model.ResponseDataDto;
import com.example.sortingdata.model.ResponseObject;
import com.example.sortingdata.servise.SortService;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class SortServiceImpl implements SortService {

    private final ExcludeService exclude;
    private final IncludeService include;

    public SortServiceImpl(ExcludeService exclude, IncludeService include) {
        this.exclude = exclude;
        this.include = include;
    }

    @Override
    public ResponseDataDto parse (RequestExcludeDataDto req){
        List<ResponseObject> resultList = transfer(req);
        if(!req.getCondition().getExclude().isEmpty()){
            List<ResponseObject> excludeResult = exclude.exclude(req,resultList);
            return sortByReqParameter(req,excludeResult);
        }



       return new ResponseDataDto(resultList);
    }
    @Override
    public List<ResponseObject> transfer(RequestExcludeDataDto req){
        List<ResponseObject> resultList = new ArrayList<>();
        req.getData().forEach(inData -> {
            resultList.add(new ResponseObject(inData.getUser(),inData.getRating(),inData.getDisabled()));
        });
        return resultList;
    }

    @Override
    public ResponseDataDto sortByReqParameter(RequestExcludeDataDto reqData, List<ResponseObject> resultList) {
        if(reqData.getCondition().getSortBy().contains("rating")){
            Comparator<ResponseObject> comparator = Comparator.comparing(ResponseObject::getRating);
            resultList.sort(comparator);
        }else if(reqData.getCondition().getSortBy().contains("name")){
            Comparator<ResponseObject> comparator = Comparator.comparing(ResponseObject::getUser);
            resultList.sort(comparator);
        }
        Comparator<ResponseObject> comparator = Comparator.comparing(ResponseObject::getDisabled);
        resultList.sort(comparator);
        return new ResponseDataDto(resultList);
     }
}
