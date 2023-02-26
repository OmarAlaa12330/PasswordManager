package Classes_Schemas;

import org.bson.types.ObjectId;

import java.util.Calendar;



public class LoginDetails {
    private final ObjectId _ID;
    private String userName, password, website;
    private int year, month;

    //creating instance
    public LoginDetails(String un, String pw, String url){
        _ID = new ObjectId(); //removed _ID from args \ needs to be made random
        userName = un;
        password = pw;
        website = url;

        //records the month and year in which the login details were made
        Calendar date = Calendar.getInstance();
        year = date.get(Calendar.YEAR);
        month = (date.get(Calendar.MONTH))+1;
    }


    //getters
    public ObjectId get_ID(){return _ID;}
    public String getUserName(){return userName;}
    public String getPassword(){return password;}
    public String getWebsite(){return website;}
    public int getMonth(){return month;}
    public int getYear(){return year;}


    //setters
    //no setter for _ID as it's a constant string
    public void setUserName(String userName){this.userName = userName;}
    public void setPassword(String password){this.password = password;}
    public void setWebsite(String website){this.website = website;}
    public void setMonth(int month){this.month = month;}
    public void setYear(int year){this.year = year;}

}
