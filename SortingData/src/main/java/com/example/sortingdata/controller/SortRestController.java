package com.example.sortingdata.controller;

import com.example.sortingdata.model.*;
import com.example.sortingdata.servise.serviceimpl.SortService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class SortRestController {


    private final SortService sortService;

    public SortRestController(SortService sortService) {
        this.sortService = sortService;
    }


    @PostMapping(value = "/sort")
    public RequestObjectDto sorting(@RequestBody RequestObjectDto data){
        sortService.parseAndSort(data);
        return null;
    }
}
