package com.example.sortingdata.controller;

import com.example.sortingdata.model.RequestExcludeDataDto;
import com.example.sortingdata.model.RequestIncludeDataDto;
import com.example.sortingdata.model.ResponseDataDto;
import com.example.sortingdata.servise.serviceimpl.SortServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class SortRestController {

    private final SortServiceImpl sortService;

    public SortRestController(SortServiceImpl sortService) {
        this.sortService = sortService;
    }


    @PostMapping(value = "/sortex",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDataDto sort(@RequestBody RequestExcludeDataDto data) {
       return sortService.parse(data);

    }

    @PostMapping(value = "/sortin",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDataDto sort(@RequestBody RequestIncludeDataDto data) {
       /* return sortService.parse(data);*/
        return null;
    }
}
