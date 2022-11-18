public enum MongoDB {
    CLIENT_URL("mongodb://localhost:27017"),
    DATABASE("Logins"),
    COLLECTION("LoginData");

    String str;
    MongoDB(String i){this.str = i;}

}
