import java.util.Scanner;

public class Validator {
    public static Scanner sc = new Scanner(System.in);

    public static int intValidator(){
        while (true){
            try {
                String input = sc.next();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("The input is not a valid Number!");
            }
        }
    }
}
