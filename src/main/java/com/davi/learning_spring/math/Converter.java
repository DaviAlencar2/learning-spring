package com.davi.learning_spring.math;

import com.davi.learning_spring.exception.UnsurppotedMathOperationException;

public class Converter {

    protected static Double convertToDouble(String number){
        if (!Converter.isNumeric (number) ) throw new UnsurppotedMathOperationException("Please set a numeric value!");
        String numberFormatted = number.replace(",",".");
        return Double.parseDouble(numberFormatted);
        
    }

    protected static boolean isNumeric(String strNumber){
        if (strNumber == null || strNumber.isBlank()) {
            return false;
        }
        String number = strNumber.replace(",",".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

}
