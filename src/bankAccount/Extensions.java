package bankAccount;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * <b>Extensions Class</b><br>
 * - Responsible for validating input and perfoming cryptographic constructions
 * throughout the application
 * - Contains methods for validating each data type used in the application
 * - Contains method for generating a random account number
 * - Contains methods for encrypting and decrypting a given String
 * - Contains method for generating an AES key for encryption and decryption
 * based on the user password
 *
 * @author David Rosoff, James Dermezis
 */
public class Extensions {
    static int myTLen = 128;
    static byte[] myIv = "1234567890123456789".getBytes();
    static GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(myTLen, myIv);

    /**
     * Validate a Given input - Takes an input and a regex query (both in string
     * form) and attempts to find a match for the query within the input
     * 
     * @param input The input you want to validate
     * @param regex The regex to use for validation
     * @return true/false - Returns true if match was found and false in all other
     *         cases
     */
    public static <T> boolean ValidateInput(T input, String regex) {
        String inputString = String.valueOf(input);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        return matcher.find();
    }

    /**
     * Generate a Random Account Number
     * https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-
     * z-and-0-9-in-java
     * 
     * @return saltStr Random Account Number
     */
    public static String GenAccountNumber() {
        String SALT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < SALT.length()) {
            int index = (int) (rnd.nextFloat() * SALT.length());
            salt.append(SALT.charAt(index));
        }

        String saltStr = salt.toString();
        return saltStr;
    }

    /**
     * Encryption method
     *
     * This method assumes that the data provided is a string, however it can easily be modified to use generics if desired
     *
     * Initialize cipher for Encryption - Better choice is "AES/GCM/PKCS5Padding",
     * however "AES/GCM/NoPadding" is used as per bug report
     * (https://bugs.openjdk.java.net/browse/JDK-8229043)
     *
     * @param data The data to encrypt
     * @param secretKey The key to use for encryption
     * @return The encrypted data encoded in Base64
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidKeyException
     * @throws InvalidAlgorithmParameterException
     */
    public static String Encrypt(String data, SecretKeySpec secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Decryption Method
     *
     * This method assumes that the data provided is a string, however it can easily be modified to use generics if desired
     *
     * Initialize cipher for Decryption - Better choice is "AES/GCM/PKCS5Padding",
     * however "AES/GCM/NoPadding" is used as per bug report
     * (https://bugs.openjdk.java.net/browse/JDK-8229043)
     * @param data Encrypted data to decrypt
     * @param secretKey The key to be used for decryption
     * @return The decrypted data
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     * @throws InvalidAlgorithmParameterException
     */
    public static String Decrypt(String data, SecretKeySpec secretKey)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException,
            BadPaddingException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmParameterSpec);
        return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
    }

    /**
     * Generates an Encryption key based on the provided password
     * @param password the password to use
     * @return The encryption key
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static SecretKeySpec genKey(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest sha = null;
        byte[] key = password.getBytes("UTF-8");
        sha = MessageDigest.getInstance("SHA-1");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        return new SecretKeySpec(key, "AES");
    }
}
