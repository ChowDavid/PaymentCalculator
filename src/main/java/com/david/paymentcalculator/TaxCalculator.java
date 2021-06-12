package com.david.paymentcalculator;

import lombok.Setter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TaxCalculator {
    @Setter
    private BigDecimal income;

    public BigDecimal getNetMonthlyIncome(){
        return getGrossMonthlyIncome().subtract(getMonthlyIncomeTax());
    }

    public BigDecimal getMonthlyIncomeTax(){
        return calculateTaxIfIncome().divide(BigDecimal.valueOf(12),2, RoundingMode.HALF_UP);
    }
    public BigDecimal calculateTaxIfIncome(){
        return calculateTaxIfIncome(income);
    }

    public BigDecimal calculateTaxIfIncome(BigDecimal income){
        BigDecimal bg20k = BigDecimal.valueOf(20*1000);
        BigDecimal bg40k = BigDecimal.valueOf(40*1000);
        BigDecimal bg80k = BigDecimal.valueOf(80*1000);
        BigDecimal bg180k = BigDecimal.valueOf(180*1000);
        if (income.compareTo(bg20k)<=0){
            return BigDecimal.ZERO;
        } else if (income.compareTo(bg40k)<=0){
            return tax(income,bg20k,0.1).add(calculateTaxIfIncome(bg20k));
        } else if (income.compareTo(bg80k)<=0){
            return tax(income,bg40k,0.2).add(calculateTaxIfIncome(bg40k));
        }else if (income.compareTo(bg180k)<=0){
            return tax(income,bg80k,0.3).add(calculateTaxIfIncome(bg80k));
        } else {
            return tax(income,bg180k,0.4).add(calculateTaxIfIncome(bg180k));
        }

    }

    public BigDecimal getGrossMonthlyIncome(){
        return income.divide(BigDecimal.valueOf(12),2, RoundingMode.HALF_UP);
    }

    private BigDecimal tax(BigDecimal income, BigDecimal base, double rate) {
        BigDecimal taxableAmount = income.subtract(base);
        return taxableAmount.multiply(BigDecimal.valueOf(rate));
    }
}
