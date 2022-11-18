import java.util.Scanner;


// Look for design patters


public class Main {
    static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {

        //login to the system first
        while (true) {
            //temporary login details to use the system
            System.out.print("Enter username=> ");
            String username = read.next();
            System.out.print("Enter password=> ");
            String password = read.next();

            if (username.equals(TempLogin.LOGIN.user) && password.equals(TempLogin.LOGIN.pw)) {
                System.out.println("Access Granted!");
                break;
            } else {System.out.println("Access Denied!!");}

        }

        new Menu();
    }
}