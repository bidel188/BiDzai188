
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Expense {
    static int lastId=0;
    private int ID; 
    private String  content;
    private double amount;
    private Date date;

    public Expense() {
    }

    public Expense( Date date, double amount, String content) {
        this.ID = ++lastId;
        this.date = date;
        this.amount = amount;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String formatDate()
    {
        String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Augut","Sep","Oct","Nov","Dec"};
        return date.getDate()+"-"+month[date.getMonth()-1]+"-"+(date.getYear()+1900);
        
        
    }
    public String toString() {
        String out = String.format("%-4d%-15s%-15.2f%-20s", ID, formatDate(), amount, content);
        return out;
    }

 //bidzai
}
