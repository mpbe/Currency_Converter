package com.company;
import java.util.Scanner;


public class Main {

    static double moneyAmountDouble;

    public static void main(String[] args) {
        // write your code here

        // This is one of the best Java project ideas to start with, because it’s pretty simple.
        // A currency converter just needs three inputs: the amount, the original currency, and the
        // currency you’re trying to convert to. From there, everything is in the back-end.
        // (You’ll have to write the conversion rates on your own.)



    /* things i wanna do:
        fix the weird static problem i have had, and understand why that is

        are doubles the best number format to use here? if so find a way to round to 2 decimals

        look into the interest taking question, that should be easy to just add a little to the method
        and maybe another line in the print to say thats gonna happen

        investigate ways in which this can be done more efficiently - ie lots! but specifically
        - use regex eg "^(gbp)$|^(usd)$|^(euro)$"gi instead of lots of or statements to shorten the equalscase thing for the strings
        - if i am to bring in more currencies and even import from the web are classes/objects the best
            way to go about this program?
        - regarding my method, should this be in the class file or where it is. fix the weird variables
     */

        Scanner scanner = new Scanner(System.in);

        Currency GBP = new Currency(1.1);
        Currency USD = new Currency(1.2);
        Currency EURO = new Currency(2.1);


        System.out.printf("gbp is %f, USD is %f, EURO is %f \n\n", GBP.getValue(), USD.getValue(), EURO.getValue());


        boolean validAmountDouble = false;

        do {
            System.out.println("how much money do you have? \n");
            String moneyAmount = scanner.nextLine();


            try {
                moneyAmountDouble = Double.parseDouble(moneyAmount);
                validAmountDouble = true; //this is here because if it gets past the above lines without the nfe
                // exception then we are good to exit the loop, otherwise it will catch and re-prompt and never reach this line
            } catch (NumberFormatException nfe) {
                System.out.println("enter a number dumbass");
            }
        } while (!validAmountDouble);


        System.out.println("available currency is as follows:\n");
        System.out.println("GBP, USD, EURO\n");


        boolean validCurrencyFromType = false;
        String convertFrom;


        do {
            System.out.println("what currency do you have?\n");
            convertFrom = scanner.nextLine();

            if (convertFrom.matches("(?i)^(gbp)$|^(usd)$|^(euro)$")) {

                validCurrencyFromType = true;
            }

        } while(!validCurrencyFromType);


   /*     do {

            System.out.println("what currency do you have?\n");
            convertFrom = scanner.nextLine();

            if (convertFrom.equalsIgnoreCase("gbp") ||
                    convertFrom.equalsIgnoreCase("usd") ||
                convertFrom.equalsIgnoreCase("EURO"))
            {
               validCurrencyFromType = true;
            }

    } while(!validCurrencyFromType);

*/
        boolean validCurrencyToType = false;
        String convertTo;

     /*   do {

            System.out.println("and which currency do you want to convert to?\n");
            convertTo = scanner.nextLine();

            if (convertTo.equalsIgnoreCase("gbp") ||
                    convertTo.equalsIgnoreCase("usd") ||
                    convertTo.equalsIgnoreCase("EURO"))
            {
                validCurrencyToType = true;
            }

        } while(!validCurrencyToType);
*/

        do {
            System.out.println("and which currency do you want to convert to?\n");
            convertTo = scanner.nextLine();

            if (convertTo.matches("(?i)^(gbp)$|^(usd)$|^(euro)$")) {

                validCurrencyToType = true;
            }

        } while(!validCurrencyToType);

        if (convertFrom.equalsIgnoreCase("gbp")) {

            convertFromDouble = GBP.getValue();

        }

        else if(convertFrom.equalsIgnoreCase("usd")) {
            convertFromDouble = USD.getValue();

        }

       else if(convertFrom.equalsIgnoreCase("EURO")) {
            convertFromDouble = EURO.getValue();

        }


        if (convertTo.equalsIgnoreCase("gbp")) {

            convertToDouble = GBP.getValue();

        }

        else if(convertTo.equalsIgnoreCase("usd")) {
            convertToDouble = USD.getValue();

        }

        else if(convertTo.equalsIgnoreCase("EURO")) {
            convertToDouble = EURO.getValue();

        }

        convert();

//ti do the conversion eg 100gbp into usd, (when gbp 1.1 usd 1.2) do 100/1.1, and then that value *1.2)










        //todo convert the string to a number and

        //todo - additionals : Challenge yourself
        //
        //    Can you pull real-time data for the currency conversion?
        //    Could you display a currency conversion for multiple currencies?
        //    Could you add a fee, such as a percentage of each conversion?



    scanner.close();
    }
    static double convertFromDouble;
    static double convertToDouble;


    public static void convert() {

        double finalValue = (moneyAmountDouble / convertFromDouble) * convertToDouble;
        System.out.printf("final value is %f", finalValue);
    }
}
