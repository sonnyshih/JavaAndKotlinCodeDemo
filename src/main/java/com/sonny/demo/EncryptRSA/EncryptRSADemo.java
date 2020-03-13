package com.sonny.demo.EncryptRSA;

import java.util.Base64;
import java.security.*;
import javax.crypto.Cipher;

import static java.lang.System.out;

public class EncryptRSADemo {

	public static byte[] encode(Key key, byte[] srcBytes) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(srcBytes);
	}

	public static byte[] decode(Key key, byte[] srcBytes) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(srcBytes);
	}

	public static String encodeBase64(Key key, byte[] srcBytes) throws Exception {
		Base64.Encoder encoder = Base64.getEncoder();

		return encoder.encodeToString(encode(key, srcBytes));
	}

	public static byte[] decodeBase64(Key key, String base64String) throws Exception {

		Base64.Decoder decoder = Base64.getDecoder();
		return decode(key, decoder.decode(base64String));
	}

	public static void main(String[] args) throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(512);
		KeyPair keyPair = keyPairGen.generateKeyPair();

		String msg = "27677005";
		out.println("明文:" + msg);

		PrivateKey privateKey = keyPair.getPrivate();
		out.println("私鑰:");
		out.println("\tFormat:" + privateKey.getFormat());
		out.println("\tkey:" + Base64.getEncoder().encodeToString(privateKey.getEncoded()));

		PublicKey publicKey = keyPair.getPublic();
		out.println("公鑰:");
		out.println("\tFormat:" + publicKey.getFormat());
		out.println("\tkey:" + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
		
		{
			out.println("公鑰加密，私鑰解密:");
			String base64Str = encodeBase64(keyPair.getPublic(), msg.getBytes());
			out.println("\t加密後:" + base64Str);
						
			byte[] decBytes = decodeBase64(keyPair.getPrivate(), base64Str);
			out.println("\t解密後:" + new String(decBytes));
		}
		
		{
			out.println("私鑰加密，公鑰解密:");
			String base64Str = encodeBase64(keyPair.getPrivate(), msg.getBytes());
			out.println("\t加密後:" + base64Str);
			byte[] decBytes = decodeBase64(keyPair.getPublic(), base64Str);
			out.println("\t解密後:" + new String(decBytes));
		}
	}
}
