public enum MongoDB {
    CLIENT_URL("mongodb://localhost:27017"),
    DATABASE("Logins"),
    COLLECTION("LoginData");

    final String str;
    MongoDB(String i){str = i;}

}