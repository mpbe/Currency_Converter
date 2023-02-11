package com.company;

public class Currency {

    private final double value;


    public Currency(double value){
            this.value = value;

        }


        public double getValue() {
            return value;
    }


    public static double convert(double moneyToConvert, double converterFrom, double converterTo) {

        double finalValue = (moneyToConvert / converterFrom) * converterTo;
        System.out.printf("final value is %f", finalValue);
        return finalValue;
    }

    //if I  give the currency a name + getName as well, can I then say in my do whiles if it equals any
    // currency name for this class then proceed?

}
