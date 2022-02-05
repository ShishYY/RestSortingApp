package com.example.sortingdata.servise;

import java.util.List;

//First generic <R> responseDto claas from server;
//Second generic <T> request from client side to server;
public interface SortService<R,T> {

    //Create new Response data structure
    List<R> constructResponseData (T request);

    List<R> sortByParameter(T reqData,List<R> resultList);

    List<R> parse(T request);

}
