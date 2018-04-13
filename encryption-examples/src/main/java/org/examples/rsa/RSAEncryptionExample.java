package org.examples.rsa;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.examples.EncryptionUtils;

/**
 * RSA can only encode small size of files:
 * 
 *  For 1024bits key size = 86bytes  = 688bits 
 *  For 2048bits key size = 214bytes = 1712bits
 *  
 *  Then you have to repeat encryption with same key and thats not considered secured.
 *  To prevent this, you should use RSA to encrypt asymetric key AES and then use it to secure communication.
 * 
 * 
 * @author Martin Klima
 */
public class RSAEncryptionExample {
    
	
	/**
	 * Main method to run the program
	 * @param args
	 * @throws Exception
	 */
    public static void main(String [] args) throws Exception {
    	
    	// We using BouncyCastle 
    	Security.addProvider(new BouncyCastleProvider());
    		
        // generate public and private keys
        KeyPair keyPair = buildKeyPair();
        
        // Save keys
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        
        EncryptionUtils.printKey(publicKey, "Public Key");
        EncryptionUtils.printKey(privateKey, "Private Key");
        
        // encrypt the message
        byte [] encrypted = encrypt(privateKey, "This is a secret message");     
        System.out.println(new String(encrypted));  // <<encrypted message>>
        
        // decrypt the message
        byte[] secret = decrypt(publicKey, encrypted);                                 
        System.out.println(new String(secret));     // This is a secret message
    }
	
    /**
     * Generate key pair
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
    	
		// Secure random generator
		SecureRandom secureRandom = new SecureRandom();

		// Key size in bits
        final int keySize = 1024;
        
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize, secureRandom);      
        
        return keyPairGenerator.genKeyPair();
        
    }
    
    /**
     * Encrypt message with given key
     * @param key
     * @param message
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(Key key, String message) throws Exception {
    	
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, key);  

        return cipher.doFinal(message.getBytes());  
    }
    
    /**
     * Decrypt message with given key
     * @param key
     * @param encrypted
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(Key key, byte [] encrypted) throws Exception {
    	
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, key);
        
        return cipher.doFinal(encrypted);
    }
    

	
}