package com.targetindia.targetready.assignment.day1;
import java.util.*;
public class CalendarPrint {
    public static void printCalendar (int month, int year) {
        if(month < 1 || month > 13 || year < 1){
            System.out.println("Invalid Input");
        }
        else{
            System.out.println("Sun Mon Tue Wed Thu Fri Sat");
            printCalendarBody(month, year);
        }
    }
    public static int findNumofDaysInMonth(int month, int year){
        if(month == 2){
            if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                return 29;
            }
            else{
                return 28;
            }
        }
        else if(month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }
        return 31;
    }
    public static void printCalendarBody(int month, int year){
        int startDay = findStartDay(month, year);
        int daysInMonth = findNumofDaysInMonth(month, year);
        for(int i=0; i<startDay; i++){
            System.out.print("    ");
        }
        for(int i=1; i<=daysInMonth; i++){
            if(i < 10){
                System.out.print(i+"   ");
            }
            else {
                System.out.print(i + "  ");
            }
            if((i+startDay) % 7 == 0){
                System.out.println();
            }
        }
    }
    public static int findStartDay(int month, int year){
        int start_day_of_0001 = 6;
        int totalDays = getTotalDays(month, year);
        return (totalDays + start_day_of_0001) % 7;
    }
    public static int getTotalDays(int month, int year){
        int numOfDays = 0;
        for (int i = 1; i < year; i++){
            if((i % 4 == 0 && i % 100 != 0) || (year % 400 == 0)){ //Is Leap Year
                numOfDays += 366;
            }
            else{
                numOfDays += 365;
            }
        }
        for (int i=1; i<month; i++){
            numOfDays += findNumofDaysInMonth(i, year);
        }
        return numOfDays;
    }
    public static void main (String[] args){
        int month, year;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Month: ");
        month = s.nextInt();
        System.out.print("Enter year: ");
        year = s.nextInt();
        printCalendar(month, year);
    }

}
