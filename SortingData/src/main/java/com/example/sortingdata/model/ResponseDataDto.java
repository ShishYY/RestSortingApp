package com.example.sortingdata.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDataDto {

    private List<ResponseObject> result;

}
