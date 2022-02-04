package com.example.unitconvector.controller;

import com.example.unitconvector.model.RequestDto;
import com.example.unitconvector.model.ResponseDistanceDto;
import com.example.unitconvector.servise.serviceimp.ConverterServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/convert")
public class ConvectorRestController {

    private final ConverterServiceImpl converterService;

    public ConvectorRestController(ConverterServiceImpl converterService) {
        this.converterService = converterService;
    }


    @PostMapping
    public ResponseDistanceDto convert(@RequestBody RequestDto req){
      return converterService.convert(req);
    }

}
