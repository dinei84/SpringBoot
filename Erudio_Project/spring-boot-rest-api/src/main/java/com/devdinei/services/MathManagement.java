package com.devdinei.services;

import com.devdinei.exception.UnsupportedMatchOperationException;

public abstract class MathManagement {

    public abstract Double oparation(
            String numberOne,
            String numberTwo
    );


    protected boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()){
            return false;
        }
        String number = strNumber.replace(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    protected Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) throw new UnsupportedMatchOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
