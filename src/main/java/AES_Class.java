import org.jetbrains.annotations.NotNull;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;


/**
 * @URl <a href="https://www.javaguides.net/2020/02/java-string-encryption-decryption-example.html">
 *     Link of the source code
 *      </a>
 *
 *      <p>Example:</p>
 *
 *      <pre>
 *      <code>      AES_Class f = new AES_Class();
 *          String oString = sc.next();
 *          String EncryptedStr = f.encrypt(oString);
 *          System.out.println(EncryptedStr);
 *          String DecryptedStr = f.decrypt(EncryptedStr);
 *          System.out.println(DecryptedStr);
 *       </code>
 *       </pre>
 * */
public class AES_Class {
    private static final String ALGORITHM = "AES";
    private static SecretKeySpec SecretKey;

    //key to encrypt and decrypt
    //TODO: make it from an algorithm that creates the key from the username and password
    private static final String privateKey = "P@s5w0rd"; //AdminShe

    public void setSecretKey(String myKey){
        MessageDigest sha;
        try{
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha =MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key,16);
            SecretKey = new SecretKeySpec(key, ALGORITHM);
        }catch(NoSuchAlgorithmException e) {e.printStackTrace();}
    }

    // turns String into an encrypted string
    public String encrypt(String strToEncrypt){
        try{
            setSecretKey(privateKey);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, SecretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));

        }catch (Exception e){
            String error = "Error while encrypting: "+ e;
            System.out.println(error);
        }
        return null;
    }

    public String decrypt(String strToDecrypt){
        try{
            setSecretKey(privateKey);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, SecretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }catch(Exception e){
            String error = "Error while decrypting: "+ e;
            System.out.println(error);
        }
        return null;
    }



}
