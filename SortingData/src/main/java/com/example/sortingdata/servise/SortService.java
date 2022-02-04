package com.example.sortingdata.servise;

import com.example.sortingdata.model.RequestExcludeDataDto;
import com.example.sortingdata.model.ResponseDataDto;
import com.example.sortingdata.model.ResponseObject;

import java.util.List;

public interface SortService {

    List<ResponseObject> transfer(RequestExcludeDataDto req);

    ResponseDataDto parse (RequestExcludeDataDto req);

    ResponseDataDto sortByReqParameter(RequestExcludeDataDto reqData, List<ResponseObject> resultList) throws NoSuchFieldException;
}
