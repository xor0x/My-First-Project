package com.project.methods;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashcode {

	// /////HashCode Start///////
	public String hashcode(String input) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA1");
		md.reset();
		byte[] buffer = input.getBytes();
		md.update(buffer);
		byte[] digest = md.digest();

		String hexStr = "";
		for (int i = 0; i < digest.length; i++) {
			hexStr += Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1);
		}
		return hexStr;
	}

	// /////HashCode End///////

}
