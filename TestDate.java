/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Bi Dzai
 */
public class TestDate {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TestDate td = new TestDate();
        while (true) {
            System.out.println(td.getDate());
        }
    }

    public String getDate() {
        String s = "";
        Pattern p = Pattern.compile("^([0-9]{2})[/]([0-9]{2})[/]([0-9]{4})$");
        int date, month, year;
        while (true) {
            s = sc.nextLine();
            if (!p.matcher(s).find()) {
                System.err.println("Your date is not correct format");
                continue;
            }
            date = Integer.parseInt(s.substring(0, 2));
            month = Integer.parseInt(s.substring(3, 5));
            year = Integer.parseInt(s.substring(6, 10));
            if (date > 31 || month > 12) {
                System.err.println("Date is not exist!");
                continue;
            }
            if (date == 31 && month != 1 && month != 3 && month != 5 && month != 7 && month != 8 && month != 10 && month != 12) {
                System.err.println("Date is not exist!");
                continue;
            }
            if (date == 30 && month == 2) {
                System.err.println("Date is not exist");
                continue;
            }
            if (date == 29 && month == 2 && (!(year % 400 == 0 && year % 100 == 0) && year % 4 != 0)) {
                System.err.println("Date is not exist");
                continue;
            }
            Date today = Calendar.getInstance().getTime();
            int todayDate = today.getDate();
            int todayMonth = today.getMonth();
            int todayYear = 1900 + today.getYear();
            if (year > todayYear) {
                System.err.println("Year");
                continue;
            } else if (year == todayYear && month > todayMonth) {
                System.err.println("Month");
                continue;
            } else if (year == todayYear && month == todayMonth && date > todayDate) {
                System.err.println("date");
                continue;
            }
            return s;

        }

    }

}
//if (date > 31 || month > 12) 
//if (date == 31 && month != 1 && month != 3 && month != 5 && month != 7 && month != 8 && month != 10 && month != 12)
//if  (date == 30 && month == 2)
//if(date == 29 && month == 2 && (!(year % 400 == 0 && year % 100 == 0) && year % 4 != 0))
