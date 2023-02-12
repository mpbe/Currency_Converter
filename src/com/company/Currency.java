package com.company;

import java.util.*;

public enum Currency {

    GBP(1.1, "£"),
    USD(1.2, "$"),
    EURO(2.1, "€"),
    MIKEDOLLARS(1000.5, "MIKE");

    private final double exchangeRate;
    private final String currencySymbol;

    Currency(double exchangeRate, String currencySymbol){
        this.exchangeRate = exchangeRate;
        this.currencySymbol = currencySymbol;
    }

    public double getExchangeRate(){
        return exchangeRate;
    }

    public String getCurrencySymbol(){
        return currencySymbol;
    }

    public static void printExchangeRates(){
        StringBuilder stringBuilder = new StringBuilder("Current Exchange Rates \n");
        for( Currency currency : Currency.values()){
            stringBuilder.append(currency.name());
            stringBuilder.append("(");
            stringBuilder.append(currency.getCurrencySymbol());
            stringBuilder.append(") - ");
            stringBuilder.append(currency.getExchangeRate());
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void printAvailableCurrencies(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<Currency.values().length; i++){
            stringBuilder.append(Currency.values()[i].name());
            if(!(i==Currency.values().length-1)){
                stringBuilder.append(",");
            }
        }
        System.out.println("Available currency is as follows: \n");
        System.out.println(stringBuilder);
    }

    public static Set<String> getCurrencyNames() {
        Set<String> names = new HashSet<>();
        for(Currency currency : Currency.values()) {
            names.add(currency.name());
        }
        return names;
    }
}
