package crypto;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;

public class Crypto {
	
	public static String sha256(String text) {
		return digest(text,"SHA-256");
	}
	
	static String digest(String text, String type) {
        MessageDigest messageDigest = null;
        try {
			messageDigest = MessageDigest.getInstance(type);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        if(null == messageDigest) {
        	throw new NullPointerException("MessageDigest is not avalibale.");
        }
        messageDigest.update(text.getBytes());
        byte byteBuffer[] = messageDigest.digest();

        StringBuffer strHexString = new StringBuffer();
        for (int i = 0; i < byteBuffer.length; i++) {
            String hex = Integer.toHexString(0xff & byteBuffer[i]);
            if (hex.length() == 1) {
                strHexString.append('0');
            }
            strHexString.append(hex);
        }
        return strHexString.toString();
	}
	
	public static void rsa() throws NoSuchAlgorithmException {
		KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
		KeyPair kp = generator.generateKeyPair();
		PrivateKey sec = kp.getPrivate();
		PublicKey pub = kp.getPublic();
		String secKey = new String(sec.getEncoded());
		String pubKey = new String(pub.getEncoded());
		System.out.println(secKey+"\t"+pubKey);
		
	}
}
