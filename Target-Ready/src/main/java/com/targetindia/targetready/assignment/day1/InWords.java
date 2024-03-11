package com.targetindia.targetready.assignment.day1;
import java.util.*;

public class InWords {
    public static String[] ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static String[] teens = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public static String[] numPlaces = {"hundred", "thousand", "lakh", "crore"};
    public static String getHundreds(int rem){
        if(rem < 100){
            return getTens(rem);
        }
        return ones[(rem/100) - 1] + " hundred " + getTens(rem % 100);
    }

    public static String getTens(int rem){
        if (rem < 10){
            return ones[rem - 1];
        }
        else if(rem % 10 == 0){
            return tens[rem / 10 - 1];
        }
        else if (rem < 20) {
            return teens[rem % 10 - 1];
        }
        return tens[(rem / 10) - 1] + " " + ones[rem % 10 - 1];
    }
    public static String inWords(int num){
        StringBuilder numToWords= new StringBuilder();
        int counter = 1;
        while (num > 0) {
            if(counter == 1){
                numToWords.insert(0, getHundreds(num % 1000));
                num /= 10;
            }
            else{
                numToWords.insert(0, getTens(num % 100) + " " + numPlaces[counter - 1] + " ");
            }
            counter++;
            num /= 100;
        }
        return numToWords.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = s.nextInt();
        System.out.println(inWords(num));
    }
}