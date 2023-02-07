import java.util.Scanner;
import java.io.Console;

// Look for design patters


/*
command:
java -classpath C:\Users\omara\IdeaProjects\PasswordManager\target\classes;C:\Users\omara\.m2\repository\org\mongodb\mongodb-driver-sync\4.7.2\mongodb-driver-sync-4.7.2.jar;C:\Users\omara\.m2\repository\org\mongodb\bson\4.7.2\bson-4.7.2.jar;C:\Users\omara\.m2\repository\org\mongodb\mongodb-driver-core\4.7.2\mongodb-driver-core-4.7.2.jar;C:\Users\omara\.m2\repository\org\mongodb\bson-record-codec\4.7.2\bson-record-codec-4.7.2.jar;C:\Users\omara\.m2\repository\org\jetbrains\annotations\24.0.0\annotations-24.0.0.jar Main
 */

public class Main {
    static Scanner read = new Scanner(System.in);

    static boolean validationMethod(){
        Console cons;
        if ((cons = System.console()) != null){ // read from "real" terminal
            System.out.print("Enter username=> ");
            String username = cons.readLine();
            String pw = new String(cons.readPassword("Enter password=> "));
            return TempLogin.LOGIN.user.equals(username) && pw.equals(TempLogin.LOGIN.pw);
        }

        //else read from the IDE terminal
        System.out.print("Enter username=> ");
        String username = read.next();
        System.out.println("WARNING! Password is visible"); //alert for user
        System.out.print("Enter password=> ");
        String password = read.next();

        //temporary login details to use the system
        return username.equals(TempLogin.LOGIN.user) && password.equals(TempLogin.LOGIN.pw);

    }



    public static void main(String[] args) {

        //login to the system first
        System.out.println(TextColour.CYAN.col+"###########################################################################");
        while (!validationMethod()) {
            System.out.println(TextColour.WARNING.col+"Access Denied!!"+TextColour.CYAN.col);
        }
        System.out.println("###########################################################################"+TextColour.RESET.col);

        //run Menu with options
        System.out.println("\n ---> Access Granted! <----\n");
        new Menu();
        shutSystem();
    }


    public static void shutSystem(){
        read.close();
        System.out.println("Thanks for your time! \nSession concluded.");
        System.exit(0);
    }
}