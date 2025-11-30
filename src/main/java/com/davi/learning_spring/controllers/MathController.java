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
        @PathVariable("numerTwo")
        String numberTwo
    ){
        return 1D;
    }

}
