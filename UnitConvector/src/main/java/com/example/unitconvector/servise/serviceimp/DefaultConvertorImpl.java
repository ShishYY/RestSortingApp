package com.example.unitconvector.servise.serviceimp;

import com.example.unitconvector.servise.DefaultConvertor;
import org.springframework.stereotype.Component;

@Component
public class  DefaultConvertorImpl implements DefaultConvertor {
    @Override
    public float meters2Ft(float a) {
        return (float) (a * 3.2808);
    }

    @Override
    public float meters2Inch(float a) {
        return (float) (a * 39.370);
    }

    @Override
    public float meters2Centimeters(float a) {
        return a/100;
    }

    @Override
    public float centimeters2Inch(float a) {
        return (float) (a * 0.39370);
    }

    @Override
    public float centimeters2Ft(float a) {
        return (float) (a * 0.032808);
    }

    @Override
    public float centimeters2meters(float a) {
        return a*100;
    }

    @Override
    public float ft2Inch(float a) {
        return a * 12;
    }

    @Override
    public float ft2meters(float a) {
        return (float) (a/3.2808);
    }

    @Override
    public float ft2centimeters(float a) {
        return (float) (a/0.032808);
    }

    @Override
    public float inch2Ft(float a) {
        return (float) (a * 0.083333);
    }

    @Override
    public float inch2meters(float a) {
        return (float) (a/39.370);
    }

    @Override
    public float inch2centimeters(float a) {
        return (float) (a* 2.54);
    }
}
