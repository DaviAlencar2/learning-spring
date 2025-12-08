package com.davi.learning_spring.math;

import com.davi.learning_spring.exception.UnsurppotedMathOperationException;

public class SimpleMath {

    public static Double sum(String numberOne, String numberTwo){
        return Converter.convertToDouble(numberOne) + Converter.convertToDouble(numberTwo);
    }

    public static Double subtraction(String numberOne, String numberTwo){
        return Converter.convertToDouble(numberOne) - Converter.convertToDouble(numberTwo);
    }

    public static Double multiplication(String numberOne, String numberTwo) {
        return Converter.convertToDouble(numberOne) * Converter.convertToDouble(numberTwo);
    }

    public static Double division(String numberOne, String numberTwo){
        Double divisor = Converter.convertToDouble(numberTwo);
        if (divisor == 0D) throw new UnsurppotedMathOperationException("Division by zero is not allowed!");
        return Converter.convertToDouble(numberOne) / divisor;
    }

    public static Double mean(String numberOne, String numberTwo){
        return (Converter.convertToDouble(numberOne) + Converter.convertToDouble(numberTwo)) / 2 ;
    }

    public static Double squareRoot(String number) {
        return Math.sqrt(Converter.convertToDouble(number));
    }

}
