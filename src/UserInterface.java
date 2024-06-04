import java.util.Scanner;

public class UserInterface {

    public void welcome() {
        System.out.println("Welcome to the Caesar cipher and Morse code program!");
    }

    public int chooseCipher(int options) {
        System.out.println("Please choose the cipher you want to use:");
        System.out.println("1. Caesar cipher");
        System.out.println("2. Morse code");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while(true){
            if (num > options || num < 1){
                System.out.println("Please enter a valid number");
            }
            else{
                break;
            }
        }
        return num;
    }


    public void render() {
        System.out.println("Please enter the text you want to encrypt:");
    }
}
