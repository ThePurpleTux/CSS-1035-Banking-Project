package bankAccount;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * <b>Validation Class</b><br>
 * - Responsible for validating input throughout the application
 * - Contains methods for validating each data type used in the application
 */
public class Extensions {

    /**
     * Validate a Given input - Takes an input and a regex query (both in string form) and attempts to find a match for the query within the input
     * @param input The input you want to validate
     * @param regex The regex to use for validation
     * @return true/false - Returns true if match was found and false in all other cases
     */
    public static <T> boolean ValidateInput(T input, String regex) {
        String inputString = String.valueOf(input);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputString);
        return matcher.find();
    }

    // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
    public static String GenAccountNumber(){
        String SALT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < SALT.length()){
            int index = (int) (rnd.nextFloat() * SALT.length());
            salt.append(SALT.charAt(index));
        }

        String saltStr = salt.toString();
        return saltStr;
    }

    public static SecretKey GenerateKeyFromPassword(char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        KeySpec keySpec = new PBEKeySpec(password, salt, 65536, 256);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = keyFactory.generateSecret(keySpec).getEncoded();

        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
        return secretKey;
    }

    public static SecretKey LoadAESKey(char[] password, String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = new byte[16];

        FileInputStream inputStream = new FileInputStream(filePath);
        inputStream.read(salt);

        KeySpec keySpec = new PBEKeySpec(password, salt, 65536, 256);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = keyFactory.generateSecret(keySpec).getEncoded();

        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
        return secretKey;
    }

    public static void Encrypt(String inputFile, String outputFile, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        Cipher cipher= Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] iv = cipher.getIV();

        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(iv);

        PublicCipherOutputStream cipherOutputStream = new PublicCipherOutputStream(outputStream, cipher);
        byte[] buffer = new byte[8192];
        int count;
        while ((count = inputStream.read(buffer)) > 0 ) {
            cipherOutputStream.write(buffer, 0, count);
        }
        cipherOutputStream.flush();
    }

    public static void Decrypt(String inputFile, String outputFile, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] iv = new byte[16];

        try (FileInputStream inputStream = new FileInputStream(inputFile)) {
            inputStream.read(iv);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

            try (FileOutputStream outputStream = new FileOutputStream(outputFile);
                 CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = cipherInputStream.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, count);
                }
                outputStream.flush();
            }
        }
    }
}

