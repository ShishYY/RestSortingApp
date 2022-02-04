package com.example.unitconvector.servise.serviceimp;

import com.example.unitconvector.model.RequestDto;
import com.example.unitconvector.model.ResponseDistanceDto;
import com.example.unitconvector.servise.Parser;
import org.springframework.stereotype.Service;

@Service
public class ConverterServiceImpl {

    private final Parser parser;

    public ConverterServiceImpl(Parser parser) {
        this.parser = parser;
    }

    public ResponseDistanceDto convert(RequestDto requestDto){
        return new ResponseDistanceDto(requestDto.getParameter(),parser.convert(requestDto));
    }
}
