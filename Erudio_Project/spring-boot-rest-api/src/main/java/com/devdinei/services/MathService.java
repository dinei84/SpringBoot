package com.devdinei.services;

public class MathService {
    private MathManagement strategy;

    public void setStrategy(MathManagement strategy) {
        this.strategy = strategy;
    }

    public Double execute(String numberOne, String numberTwo){
        return strategy.oparation(numberOne, numberTwo);
    }
}
