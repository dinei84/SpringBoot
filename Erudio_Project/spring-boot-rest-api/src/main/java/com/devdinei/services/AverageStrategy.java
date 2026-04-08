package com.devdinei.services;

import com.devdinei.exception.UnsupportedMatchOperationException;

public class AverageStrategy extends MathManagement{
    @Override
    public Double oparation(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMatchOperationException("Please set a numeric value!");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }
}
