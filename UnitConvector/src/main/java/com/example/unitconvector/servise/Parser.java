package com.example.unitconvector.servise;

import com.example.unitconvector.model.RequestDto;
import com.example.unitconvector.servise.serviceimp.DefaultConvertorImpl;
import org.springframework.stereotype.Component;

@Component
public class Parser {

    private final DefaultConvertorImpl defaultConvertor;

    public Parser(DefaultConvertorImpl defaultConvertor) {
        this.defaultConvertor = defaultConvertor;
    }

    public float convert(RequestDto req) {
        String parameter = req.getDistance().getUnit();
        String parameterTo = req.getParameter();
        float temp = req.getDistance().getValue();
        float result = 0;
        if (parameter.equals("m")) {
            switch (parameterTo) {
                case ("ft"):result = defaultConvertor.meters2Ft(temp);
                    break;
                case ("inch"):result = defaultConvertor.meters2Inch(temp);
                    break;
                case ("cm"):result = defaultConvertor.meters2Centimeters(temp);
                    break;
            }
        }
            if (parameter.equals("ft")) {
                switch (parameterTo) {
                    case ("m"):result = defaultConvertor.ft2meters(temp);
                        break;
                    case ("cm"):result = defaultConvertor.ft2centimeters(temp);
                        break;
                    case ("inch"):result = defaultConvertor.ft2Inch(temp);
                        break;
                }
            }
                if(parameter.equals("inch")){
                    switch(parameterTo){
                        case ("m"):result = defaultConvertor.inch2meters(temp);
                        break;
                        case ("cm"):result = defaultConvertor.inch2centimeters(temp);
                        break;
                        case ("ft"):result = defaultConvertor.inch2Ft(temp);
                    }
                }
                if(parameter.equals("cm")){
                    switch (parameterTo){
                        case ("m"):result=defaultConvertor.centimeters2meters(temp);
                        break;
                        case ("ft"):result = defaultConvertor.centimeters2Ft(temp);
                        break;
                        case ("inch"):result = defaultConvertor.centimeters2Inch(temp);
                    }
                }
        return result;
    }
}
