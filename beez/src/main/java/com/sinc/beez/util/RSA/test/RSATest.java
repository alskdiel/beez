package com.sinc.beez.util.RSA.test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import com.sinc.beez.util.RSA.createKey.RSAKeyManger;

public class RSATest {
	public static void main(String[] args) {
		String pri_filename = "id_rsa";
		String pub_filename = "id_rsa.pub";
		String plainText = "KimKichan";
		try {
			System.out.println(plainText);
			RSAPrivateKey rpk =  RSAKeyManger.getPrivateKey(pri_filename);
			RSAPublicKey rbk = RSAKeyManger.getPublicKey(pub_filename);
			String temp = RSAKeyManger.encrypt(plainText, rbk);
			System.out.println(temp);
			String result = RSAKeyManger.decrypt(temp, rpk);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}