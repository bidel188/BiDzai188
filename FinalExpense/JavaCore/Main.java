
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Main {
    
    //display menu
    static void menu() {
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expense");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }
    
    public static void main(String[] args) {
        ArrayList<Expense> list = new ArrayList<Expense>();
        Input input = new Input();
        Function handyExpense = new Function();
        //int ID = 0;
        //allow user can choose different option
        while(true) {
            menu();
            int option = input.inputInt("Your choice: ", 1, 4);
            //handing option
            switch(option) {
                case 1:
                    handyExpense.addExpense(list);
                    break;
                case 2:
                    handyExpense.display(list);
                    break;
                case 3:
                    handyExpense.removeExpense(list);
                    break;
                case 4: 
                    //return;
                    System.exit(0);
            }
        }
    }
}
