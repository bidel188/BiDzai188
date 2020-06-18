
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Function {

    
    //add new expense
    public void addExpense(ArrayList<Expense> list) {
        Input input = new Input();
        Date date = input.inputDate("Enter Date: ");
        double amount = input.inputDouble("Enter Amount: ", 0, Double.MAX_VALUE);
        String content = input.inputString("Enter Content: ");
        Expense e = new Expense(date, amount, content);
        list.add(e);
        System.out.println("Add new expense successfully");
    }
    
    //remove an expense
    public void removeExpense(ArrayList<Expense> list) {
        Input input = new Input();
        int ID = input.inputInt("Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int size = list.size();
        //point to each expense in list
        for (int i = 0; i < size; i++) {
            Expense e = list.get(i);
            //check id of expense equals input id or not
            if (e.getID() == ID) {
                list.remove(i);
               // resetID(i,list);
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("ID does not exist");
    }
    //display all expense
    public void display(ArrayList<Expense> list) {
        if(list.size()==0)//check if have not any expense in list
        {
            System.out.println("List is empty");
            return;
        }
        double total = 0;
        System.out.println(String.format("%-4s%-15s%-15s%-20s", "ID", "Date", "Amount", "Content"));
        //point to each expense in list
        for (Expense e: list) {
            System.out.println(e);
            total = total + e.getAmount();
        }
        System.out.println("\t\tTotal: " + total);
    }
    public void menu() {
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expense");
        System.out.println("3. Delete an expense");
        System.out.println("4. Quit");
    }
     //bidzai
}
