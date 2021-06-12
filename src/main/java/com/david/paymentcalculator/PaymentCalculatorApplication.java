package com.david.paymentcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class PaymentCalculatorApplication implements CommandLineRunner {

    @Autowired
    TaxCalculator calculator;


    public static void main(String[] args) {
        SpringApplication.run(PaymentCalculatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length>=2) {
            String name = args[args.length-2];
            String income = args[args.length-1];
            System.out.printf("Monthly Payslip for:\"%s\"%n", name);
            calculator.setIncome(BigDecimal.valueOf(Double.valueOf(income)));
            System.out.printf("Gross Monthly Income:$%1.0f%n", calculator.getGrossMonthlyIncome());
            System.out.printf("Monthly Income Tax:$%1.0f%n", calculator.getMonthlyIncomeTax());
            System.out.printf("Net Monthly Income:$%1.0f%n", calculator.getNetMonthlyIncome());
        }

    }
}
