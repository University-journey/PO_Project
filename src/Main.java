import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final String setting_file = "src/settings.properties";
    public static void main(String[] args) {
        Properties settings = new Properties();
        int shift = 0;

        try {
            settings.load(new FileInputStream(setting_file));
            shift = Integer.parseInt(settings.getProperty("CEZAR_SHIFT"));
        } catch (IOException e) {
            System.out.println("Nie można wczytać pliku konfiguracyjnego: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Błąd w formacie danych konfiguracyjnych: " + e.getMessage());
            return;
        }


        // Dodaje interfejs uzytkownika
        UserInterface ui = new UserInterface();
        ui.welcome();
        Scanner scanner = new Scanner(System.in);
        // Pobieram dane z settings

        outerLoop: while(true){
//            ui.render();
            int num = ui.chooseCipher(3);
            switch(num) {
                case 1:
                    System.out.println("Please enter the text you want to encrypt:");
                    String text = scanner.nextLine();
                    Szyfr_Cezara k = new Szyfr_Cezara(text);
                    k.cipher(shift);
                    k.decipher(shift);
                    break;
                case 2:
                    System.out.println("Please enter the text you want to encrypt:");
                    break;
                case 3:
                    System.out.println("Goodbye! ");
                    break outerLoop;
                default:
                    System.out.println("Please enter a valid number");
            }



        }
//        Szyfr_Cezara k = new Szyfr_Cezara("abcdefg");
//        k.cipher(24);
//        k.decipher(24);
    }
}