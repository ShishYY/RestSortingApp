package com.example.unitconvector.servise;

import com.example.unitconvector.model.ResponseDistanceDto;

public interface DefaultConvertor {

    float meters2Ft(float a);

    float meters2Inch(float a);

    float meters2Centimeters(float a);

    float centimeters2Inch(float a);

    float centimeters2Ft(float a);

    float centimeters2meters(float a);

    float ft2Inch(float a);

    float ft2meters(float a);

    float ft2centimeters(float a);

    float inch2Ft(float a);

    float inch2meters(float a);

    float inch2centimeters(float a);

}
