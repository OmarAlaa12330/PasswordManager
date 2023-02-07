public enum TempLogin {

    LOGIN("Admin", "Password");

    final String user, pw;
    TempLogin(String inp, String inp2){
        this.user = inp;
        this.pw = inp2;
    }
}
