import java.util.Scanner;
import java.io.Console;

// Look for design patters



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
        String logo = "______                                          _  ___  ___                                        \n" +
                "| ___ \\                                        | | |  \\/  |                                        \n" +
                "| |_/ /__ _  ___  ___ __      __ ___   _ __  __| | | .  . |  __ _  _ __    __ _   __ _   ___  _ __ \n" +
                "|  __// _` |/ __|/ __|\\ \\ /\\ / // _ \\ | '__|/ _` | | |\\/| | / _` || '_ \\  / _` | / _` | / _ \\| '__|\n" +
                "| |  | (_| |\\__ \\\\__ \\ \\ V  V /| (_) || |  | (_| | | |  | || (_| || | | || (_| || (_| ||  __/| |   \n" +
                "\\_|   \\__,_||___/|___/  \\_/\\_/  \\___/ |_|   \\__,_| \\_|  |_/ \\__,_||_| |_| \\__,_| \\__, | \\___||_|   \n" +
                "                                                                                  __/ |            \n" +
                "                                                                                 |___/             \n\n";

        //login to the system first
        System.out.println(logo+ TextColour.CYAN.col+"###########################################################################");
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