public enum MongoDB {
    CLIENT_URL(),
    DATABASE(),
    COLLECTION();

    String str;
    MongoDB(String i){this.str = i;}

}