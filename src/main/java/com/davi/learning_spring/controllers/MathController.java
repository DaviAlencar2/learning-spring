package com.davi.learning_spring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    // O spring converte tipos primitivos, então poderia recebr os parametros como double, mas para fins de tratamente de dados o professor vai receber como string, outra sugestao é usando BigDecimal e preciceSum.
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
        @PathVariable("numberOne")
        String numberOne,
        @PathVariable("numberTwo")
        String numberTwo
    ) throws Exception 

    {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo) ) throw new IllegalArgumentException("Algum parametro nao e numerico!");
        
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String number){
        if (!isNumeric (number) ) throw new IllegalArgumentException("Algum parametro nao e numerico!");
        String numberFormatted = number.replace(",",".");
        return Double.parseDouble(numberFormatted);
        
    }

    private boolean isNumeric(String strNumber){
        String number = strNumber.replace(",",".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }

}
