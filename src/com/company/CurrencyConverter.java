package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConverter {

    Scanner scanner;
    DecimalFormat decimalFormat;


    public CurrencyConverter(Scanner scanner, DecimalFormat decimalFormat) {
        this.scanner = scanner;
        this.decimalFormat = decimalFormat;
    }

    public double getValueToConvert() {
        System.out.println("How much money do you have?");
        String valueString = scanner.nextLine();

        return convertValueStringToDouble(valueString);
    }

    /*
    Notice that getting the 'from' and 'to' currency does exactly the same just with a different message.
    I made a single method that allows you to get the currency and specify the message that comes before.
    The getCurrency method can now be reused if you ever need to get a currency for anything else.
     */
    public Currency getCurrencyToConvertFrom(){
        Currency.printAvailableCurrencies();
        return getCurrency("What currency do you have?");
    }

    public Currency getCurrencyToConvertTo(){
        return getCurrency("and which currency do you want to convert to?");
    }

    public void printOutConversion(double valueToConvert, Currency currencyFrom, Currency currencyTo){
        System.out.println("Final value is " + currencyTo.getCurrencySymbol() + decimalFormat.format(convertCurrency(valueToConvert, currencyFrom, currencyTo)));
    }

    private Currency getCurrency(String message){
        System.out.println(message);
        String currency = scanner.nextLine();

        if(!Currency.getCurrencyNames().contains(currency.toUpperCase().trim())) {
            System.out.println("Put a valid currency in you twat!");
            // This is called recursion (when a method calls itself).
            getCurrency(message);
        }
        return Currency.valueOf(currency.toUpperCase());
    }

    private double convertValueStringToDouble(String value) {
            try {
                return Double.parseDouble(value);

            } catch (NumberFormatException nfe) {
                System.out.println("Enter a number dumbass");
                return getValueToConvert();
            }
    }

    private double convertCurrency(double value, Currency convertFrom, Currency convertTo){
        return (value / convertFrom.getExchangeRate()) * convertTo.getExchangeRate();
    }
}
