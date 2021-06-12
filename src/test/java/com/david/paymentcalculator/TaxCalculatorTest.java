package com.david.paymentcalculator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
public class TaxCalculatorTest {

    @Autowired
    private TaxCalculator taxCalculator;
    
    @Test
    public void taxIfIncome10k(){
        Assert.assertEquals(0,taxCalculator.calculateTaxIfIncome(BigDecimal.valueOf(10*1000)).doubleValue(),0.1);
    }
    @Test
    public void taxIfIncome20k(){
        Assert.assertEquals(0,taxCalculator.calculateTaxIfIncome(BigDecimal.valueOf(20*1000)).doubleValue(),0.1);
    }
    @Test
    public void taxIfIncome20001(){
        Assert.assertEquals(0.1,taxCalculator.calculateTaxIfIncome(BigDecimal.valueOf(20*1000+1)).doubleValue(),0.1);
    }
    @Test
    public void taxIfIncome40k(){
        Assert.assertEquals(2000,taxCalculator.calculateTaxIfIncome(BigDecimal.valueOf(40*1000)).doubleValue(),0.1);
    }
    @Test
    public void taxIfIncome80k(){
        Assert.assertEquals(10000,taxCalculator.calculateTaxIfIncome(BigDecimal.valueOf(80*1000)).doubleValue(),0.1);
    }
    @Test
    public void taxIfIncome180k(){
        Assert.assertEquals(40000,taxCalculator.calculateTaxIfIncome(BigDecimal.valueOf(180*1000)).doubleValue(),0.1);
    }
    @Test
    public void taxIfIncome200k(){
        Assert.assertEquals(48000,taxCalculator.calculateTaxIfIncome(BigDecimal.valueOf(200*1000)).doubleValue(),0.1);
    }



}