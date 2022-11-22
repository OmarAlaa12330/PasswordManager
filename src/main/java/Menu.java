import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public Menu(){
        String intro = "Hello, this is a password manager\n";
        while(true) {
            String options = """
                    What option would you like to do?
                    1- Add a new login.
                    2- Show all recorded logins.
                    3- Show a login.
                    4- Exit Session.
                    Please choose one of these options:\s"""
                    ;
            System.out.print(intro + options);
            int option = Validator.intValidator();

            switch (option) {
                case 1 -> MongoDBHelpers.addLogin();
                case 2 -> MongoDBHelpers.retrieveAllLogins();
                case 3 -> MongoDBHelpers.retrieveLogin();
                case 4 -> shutSystem();
                default -> wrongInput();
            }
        }


    }
    public static void shutSystem(){
        sc.close();
        System.out.println("Thanks for your time! \nSession concluded.");
        System.exit(0);
    }

    void wrongInput(){
        System.out.println("Wrong Input you fool! \nPlease try again.");
    }

}
