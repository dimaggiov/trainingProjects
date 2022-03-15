package com.mthree.foundations.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Birthday {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("When is your birthday? ");
        String birthdayString = scanner.nextLine();

        LocalDate birthday = LocalDate.parse(birthdayString, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate today = LocalDate.now();
        LocalDate thisYearsBirthday = birthday.plusYears(today.getYear() - birthday.getYear());
        long daysToBirthday = ChronoUnit.DAYS.between(today, thisYearsBirthday);
        Period yearsOld = Period.between(birthday, thisYearsBirthday);


        System.out.println("You were born on a " + birthday.getDayOfWeek());
        System.out.println("This year your birthday is on a " + thisYearsBirthday.getDayOfWeek());
        System.out.println("And since today is " + today + " theres only " + daysToBirthday + " to the next one");
        System.out.println("Bet your excited to be turning " + yearsOld.getYears());





    }
}
