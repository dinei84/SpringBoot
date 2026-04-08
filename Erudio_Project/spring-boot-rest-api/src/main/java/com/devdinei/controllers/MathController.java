package com.devdinei.controllers;

import com.devdinei.services.MathService;
import com.devdinei.services.SubStrategy;
import com.devdinei.services.SumStrategy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/.../...
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ){
        MathService sum = new MathService();
        sum.setStrategy(new SumStrategy());
        return sum.execute(numberOne, numberTwo);
    }

    //http://localhost:8080/math/sub/.../...
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ){
        MathService sub = new MathService();
        sub.setStrategy(new SubStrategy());
        return sub.execute(numberOne, numberTwo);
    }

    //http://localhost:8080/math/multiply/.../...
    @RequestMapping("/multiply/{numberOne}/{numberTwo}")
    public Double multiply(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ){
        MathService multiply = new MathService();
        multiply.setStrategy(new SubStrategy());
        return multiply.execute(numberOne, numberTwo);
    }

    //http://localhost:8080/math/multiply/.../...
    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(
            @PathVariable String numberOne,
            @PathVariable String numberTwo
    ){
        MathService average = new MathService();
        average.setStrategy(new SubStrategy());
        return average.execute(numberOne, numberTwo);
    }


}
