import Classes_Schemas.LoginDetails;

import com.mongodb.client.*;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class MongoDBHelpers {
    static MongoClient client = MongoClients.create(MongoDB.CLIENT_URL.str);
    static MongoDatabase db = client.getDatabase(MongoDB.DATABASE.str);
    static MongoCollection<Document> col = db.getCollection(MongoDB.COLLECTION.str);
    static Scanner read  = new Scanner(System.in);
    static AES_Class aes = new AES_Class();

    private MongoDBHelpers(){}

    static LoginDetails decryptDoc(Document info){
        LoginDetails loginInstance = new LoginDetails(
                aes.decrypt(info.get("userName").toString()),
                aes.decrypt(info.get("password").toString()),
                aes.decrypt(info.get("website").toString())
        );
        loginInstance.setMonth(Integer.parseInt(aes.decrypt(info.get("month").toString())));
        loginInstance.setYear(Integer.parseInt(aes.decrypt(info.get("year").toString())));
        return loginInstance;
    }


    /**
     * Adds a new login detail (Encrypted) to the database.
     * Prints out in the console if successful or throws error if not
     *<p>TODO Add check to see if the login details are already registered or not.</p>
     * TODO Adding an encryption to the database for the password (To be tested, successful for now, needs more extensive tests)
     */
    public static void addLogin(){

        System.out.println("\n add new login details\n");
        System.out.print("Enter username=> ");
        String username = read.next();

        System.out.print("Enter password=> ");
        String password = read.next();

        System.out.print("Enter website=> ");
        String website = read.next();

        LoginDetails info =  new LoginDetails(username, password, website);

        try {
            Document doc = new Document("_id", info.get_ID())
                    .append("userName", aes.encrypt(info.getUserName()) )
                    .append("password", aes.encrypt(info.getPassword()))
                    .append("website", aes.encrypt(info.getWebsite()))
                    .append("month", aes.encrypt(Integer.toString(info.getMonth())))
                    .append("year", aes.encrypt(Integer.toString(info.getYear())));
            InsertOneResult result = col.insertOne(doc);
            System.out.println(("Success! Inserted document id: " + result.getInsertedId()));
        }catch(Exception e){
            System.out.println("!!!!!!!![ERROR CAUGHT]!!!!!!!!");
            e.printStackTrace();
        }
    }


    //returns all the logins in the MongoDB database
    public static void retrieveAllLogins(){

        FindIterable<Document> iterDoc = col.find();
        long count  = col.countDocuments();
        System.out.println("Total number of passwords is registered are "+count);

        List<LoginDetails> logins = new ArrayList<>();

        // decrypts all the retrieved logins, and adds them to the array
        for (Document document : iterDoc) {
            LoginDetails loginInstance = decryptDoc(document);
            logins.add(loginInstance);
        }


        System.out.println("All logins websites are:\n");
        for (LoginDetails info: logins){
            String loginStrConstructor=String.format("%-40s | %-40s | \n%-40s | %-40s |\n",
                    "Website: "+info.getWebsite(),
                    "Login added in: "+info.getMonth()+"/"+info.getYear(),
                    "Username: "+info.getUserName(),
                    "Password:  "+info.getPassword());
            System.out.println(loginStrConstructor);
        }
    }


    public static void retrieveLogin(){
        System.out.print("Enter the username: ");
        String username = read.next();

        FindIterable<Document> coll = col.find(eq("userName",aes.encrypt(username)));
        System.out.println("Items found: ");
        for (Document doc: coll){
            LoginDetails decryptedDoc = decryptDoc(doc);
            String loginStrConstructor=String.format("%-40s | %-40s | \n%-40s | %-40s |\n",
                    "Website: " + decryptedDoc.getWebsite(),
                    "Login added in: "+decryptedDoc.getMonth()+"/"+decryptedDoc.getYear(),
                    "Username: "+decryptedDoc.getUserName(),
                    "Password:  "+decryptedDoc.getPassword());
            System.out.println(loginStrConstructor);
        }

    }
}
