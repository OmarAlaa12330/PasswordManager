import java.util.Scanner;

public class Menu {
    public static Scanner sc = new Scanner(System.in);

    public Menu(){
        String intro = "Hello, this is a password manager\n";
        while(true) {
            String options = "What option would you like to do?\n"
                    + "1- Add a new login.\n"
                    + "2- Show all recorded logins.\n"
                    + "3- Show a login.\n"
                    + "4- Exit Session.\n"
                    + "Please choose one of these options: "
                    ;
            System.out.print(intro + options);
            int option = sc.nextInt();

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
