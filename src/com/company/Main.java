package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CurrencyConverter currencyConverter = new CurrencyConverter(new Scanner(System.in), new DecimalFormat("0.00"));

        // print exchange rates
        Currency.printExchangeRates();

        //get value of money to convert
        double value = currencyConverter.getValueToConvert();

        //get currency that value is in
        Currency currencyFrom = currencyConverter.getCurrencyToConvertFrom();

        // get currency to convert to
        Currency currencyTo = currencyConverter.getCurrencyToConvertTo();

        // print out converted value
        currencyConverter.printOutConversion(value, currencyFrom, currencyTo);
    }
}
