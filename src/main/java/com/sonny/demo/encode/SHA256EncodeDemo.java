package com.sonny.demo.encode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256EncodeDemo {

	public static void main(String[] args) {
		String password = "123456";
		MessageDigest messageDigest;
		FileInputStream fileInputStream;

		try {
			messageDigest = MessageDigest.getInstance("SHA-256");

			// password translates to SHA-256
//			byte[] dataBytes = password.getBytes();
//			messageDigest.update(dataBytes);

			// file's bytes translate to SHA-256
			fileInputStream = new FileInputStream("d:\\temp\\setting 5.jpg");
			byte[] dataBytes = new byte[1024];
			int nread = 0;
			while ((nread = fileInputStream.read(dataBytes)) != -1) {
				messageDigest.update(dataBytes, 0, nread);
			}
			
			byte[] byteData = messageDigest.digest();

			/** ##### Suggest use method 1 ##### */
			/* convert the byte to hex format method 1 */
			// Convert a byte array to a Hex string
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
//				System.out.println("[origan]: "+ byteData[i]);
//				System.out.println("[origan & 0xff]: "+(byteData[i] & 0xff));	// bye translates to Hex
//				System.out.println("[origan & 0xff + 0x100]: " + (byteData[i] & 0xff)+0x100);
//				System.out.println("[Integer.toString, 16]: " + Integer.toString((byteData[i] & 0xff) + 0x100, 16));
//				System.out.println("[Integer.toString, 16, substring(1)]: " + Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
//				System.out.println("###################################");
				
				// Byte translate to Hex string.
				stringBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			System.out.println("Hex format : " + stringBuffer.toString());

			// convert the byte to hex format method 2
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(byteData[i] & 0xff);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);

			}

			System.out.println("Hex format : " + hexString.toString());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
