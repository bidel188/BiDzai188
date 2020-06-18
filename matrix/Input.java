/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import java.util.Scanner;

/**
 *
 * @author Bi Dzai
 */
public class Input {
   
    //get input integer number between min and max
    int getInputInt(String message, String error, int min, int max) {
        int number;
        Scanner sc = new Scanner(System.in);
        //force user input exectly integer number
        while (true) {
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine());//check range of number
                if (number < min || number > max) {
                    System.out.println(error);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Values of matrix must be the number!");
            }
        }
        
    }
    int getInputChoice(String message, String error, int min, int max) {
        int number;
        Scanner sc = new Scanner(System.in);
        //force user input exectly integer number
        while (true) {
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine());                //check range of number
                if (number < min || number > max) {
                    System.out.println(error);
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Your choice must be number");
            }
        }
        
    }
    
    
}
