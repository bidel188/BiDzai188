
import java.util.ArrayList;
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
public class ExpenseList {
    
    private List<Expense> list;
    private Validation check;

    public ExpenseList() {
        list = new ArrayList<>();
        check = new Validation();
    }
    
    //add new expense
    public void addExpense() {
        int ID;
        //set ID auto increment
        if (list.size() == 0) ID = 1;
        else ID = list.get(list.size()-1).getID() + 1;
        String date = check.inputDate("Enter Date: ");
        double amount = check.inputDouble("Enter Amount: ", 0, Double.MAX_VALUE);
        String content = check.inputString("Enter Content: ");
        Expense e = new Expense(ID, date, amount, content);
        //add expense to list
        list.add(e);
        System.out.println("Add new expense successfully");
    }
    
    //remove an expense
    public void removeExpense() {
        int ID = check.inputInt("Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int size = list.size();
        //point to each expense in list
        for (int i = 0; i < size; i++) {
            Expense e = list.get(i);
            //check id of expense equals input id or not
            if (e.getID() == ID) {
                list.remove(i);
                resetID(i);
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("ID does not exist");
    }
    
    public void resetID(int n) {
        int size = list.size();
        for (int i = n; i < size; i++) {
            Expense e = list.get(i);
            e.setID(i+1);
        }
    }
    
    //display all expense
    public void display() {
        double total = 0;
        System.out.println(String.format("%-4s%-15s%-15s%-20s", "ID", "Date", "Amount", "Content"));
        //point to each expense in list
        for (Expense e: list) {
            System.out.println(e);
            total = total + e.getAmount();
        }
        System.out.println("\t\tTotal: " + total);
    }
    
}
