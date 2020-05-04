package model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    public static byte [] getHash(String pasw){
        MessageDigest digest=null;
        byte [] hash = null;
        try {
            digest=MessageDigest.getInstance("MD5");
            digest.reset();
            hash = digest.digest(pasw.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();}
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return hash;
    }


}
