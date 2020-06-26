package tienphongbank;
import java.util.Locale;
public class Validation {

    //Function to check if user input correct captcha
    public boolean checkInputCaptcha(String randomCaptcha, Locale language) {
        Function function = new Function();
        Input input = new Input();
        System.out.println(randomCaptcha);
        function.getWordLanguage(language, "enterCaptcha");
        String captchaInput = input.getInputString(language);
        //point each chracter in captcha user input
        for (int i = 0; i < captchaInput.length(); i++) {
            //check if random captcha contain all or one part of captcha that user input
            if (!randomCaptcha.contains(Character.toString(captchaInput.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    //funciton to check password user input is valid or not
    public boolean checkValidPassword(String password, Locale language) {
        Function function = new Function();
        int lengthPassword = password.length();
        if (lengthPassword < 8 || lengthPassword > 31) {//check if length of password is in range 8-31 or not
            function.getWordLanguage(language, "errCheckLengthPassword");
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;
            //Point each character in password user input
            for (int i = 0; i < lengthPassword - 1; i++) {
                //check if current character is a digit
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {//check if current character is letter
                    countLetter++;
                }
            }
            if (countDigit < 1 || countLetter < 1) {//check if password contain at least 1 letter and 1digit 
                function.getWordLanguage(language, "errCheckAlphanumericPassword");
                System.out.println();
                return false;
            }
        }
        return true;
    }

}
