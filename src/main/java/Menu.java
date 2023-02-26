
public class Menu {
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
                case 1 -> MongoDBAPI.addLogin();
                case 2 -> MongoDBAPI.retrieveAllLogins();
                case 3 -> MongoDBAPI.retrieveLogin();
                case 4 -> {
                    return;
                }
                default -> wrongInput();
            }
        }


    }


    void wrongInput(){
        System.err.println("Invalid input, please try again");
    }

}
