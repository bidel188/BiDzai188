
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
    
    
    public static void main(String[] args) {
        ArrayList<Expense> list = new ArrayList<Expense>();
        Input input = new Input();
        Function function = new Function();
        //int ID = 0;
        //allow user can choose different option
        while(true) {
            function.menu();
            int option = input.inputInt("Your choice: ", 1, 4);
            //handing option
            switch(option) {
                case 1:
                    function.addExpense(list);
                    break;
                case 2:
                    function.display(list);
                    break;
                case 3:
                    function.removeExpense(list);
                    break;
                case 4: 
                    //return;
                    System.exit(0);
            }
        }
    }
     //bidzai
}
