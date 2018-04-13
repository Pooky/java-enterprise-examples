package org.examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.Base64;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

public class EncryptionUtils {

	
	public static String encodeToBase64(Object value) {
		return Base64.getEncoder().encodeToString((byte[]) value);
	}

	public static void printKey(Key key, String keyTitle) {

		System.out.println("=== " + keyTitle + ", " + key.getAlgorithm() + ", " + key.getEncoded().length + " length,"
				+ key.getFormat() + " ===");

		// Write key as PEM format (Privacy Enhancemend Mail format)
		PemObject pemObject = new PemObject(keyTitle, key.getEncoded());
		PemWriter pemWriter = new PemWriter(new PrintWriter(System.out));		
		
		try {
			pemWriter.writeObject(pemObject);
			pemWriter.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		} 
		

	}
	
	


}
