package tienphongbank;
import java.util.Locale;
import java.util.Scanner;

public class Input {
 
    //Function to get a integer in range from min to max 
    public int getInputInt(int min, int max, Locale language) {
        Scanner sc = new Scanner(System.in);
        Function function = new Function();
        //force user input valid integer
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine());
                if (result < min || result > max) { //check if number is out of range or not
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                function.getWordLanguage(language, "errorCheckInputIntLimit");
                System.out.println();
            }
        }
    }
    //Function to get a not null or empty string
    public String getInputString(Locale language) {
        Function function = new Function();
        Scanner sc = new Scanner(System.in);
        //force user to input valid string
        while (true) {
            String result = sc.nextLine();
            if (result.trim().length() == 0) {//check if user input null or full of space string
                function.getWordLanguage(language, "errCheckInputIntLimit");
                System.out.println();
            } else {
                return result;
            }
        }
    }
    //Function to get valid account
    public int getInputAccount(Locale language) {
        String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
        Function function = new Function();
        Scanner sc = new Scanner(System.in);
        //force user to input valid account
        while (true) {
            String result = sc.nextLine();
            //check if string is correct format (only contain digit and have 10 length
            if (result.matches(ACCOUNT_NUMBER_VALID)) {
                return Integer.parseInt(result);
            }
            function.getWordLanguage(language, "errCheckInputAccount");
            System.out.println();
        }
    }
    //Function to get valid password from user
    public String getInputPassword(Locale language) {
        Validation v = new Validation();
        String result;
        //force user to input valid password
        while (true) {
            result = getInputString(language);
            if (v.checkValidPassword(result, language)) { //check if user is valid or not
                return result;
            }
        }
    }

}
