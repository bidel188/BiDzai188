package tienphongbank;
import java.util.Locale;
import java.util.ResourceBundle;
public class Function {
    //function to get random captcha for verify
    public String getRandomCaptchaText() {
        char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
            'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
            'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
            'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
            '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
            'Y', 'y', 'Z', 'z', '9'};
        String randomStrValue = "";
        int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < LENGTH; i++) {//point to each index of captcha strings
            index = (int) (Math.random() * (chars.length - 1));
            sb.append(chars[index]);
        }
        return sb.toString();
    }
    //function to get notification base on language that user choose
    public void getWordLanguage(Locale curLocate, String key) {
        ResourceBundle words
                = ResourceBundle.getBundle("Language/" + curLocate, curLocate);
        String value = words.getString(key);
        System.out.printf(value);
    }
    //Function to login
    public void login(Locale language) {
        Input input = new Input();
        Validation v = new Validation();
        Function function = new Function();
        getWordLanguage(language, "enterAccountNumber");
        int accountNumber = input.getInputAccount(language);
        getWordLanguage(language, "enterPassword");
        String passString = input.getInputPassword(language);
        String captchaGenerated = getRandomCaptchaText();
        //force user input correct captcha
        while (true) {
            if (v.checkInputCaptcha(captchaGenerated, language)) {//check is user input correct captcha
                getWordLanguage(language, "loginSuccess");
                System.out.println();
                return;
            } else {
                getWordLanguage(language, "errCaptchaIncorrect");
                System.out.print(": ");
            }
        }
    }
    //function to display all functin for user choose
    public void display() {
        Input input = new Input();
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
        int choice = input.getInputInt(1, 3, english);
        switch (choice) {
            case 1://if user want to use vietnamese
                login(vietnamese);
                break;
            case 2://if user want to use english
                login(english);
                break;
            case 3://if usre want to exit
                return;
        }
    }

}
