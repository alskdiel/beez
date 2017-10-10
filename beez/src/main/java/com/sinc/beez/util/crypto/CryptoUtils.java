package com.sinc.beez.util.crypto;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;

import com.sinc.beez.util.ByteUtils;

public class CryptoUtils {
	private static final String transformation = "DESede/ECB/PKCS5Padding";

	public static byte[] tDesEnc(String plainTxt, String privateKey) {
		byte[] encrypt = null;
		try {
			Key key = CipherUtil.generateKey("DESede",
					ByteUtils.toBytes(privateKey, 16));
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, key);

			String str = plainTxt;
			byte[] plain = str.getBytes();
			encrypt = cipher.doFinal(plain);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encrypt;
	}

	public static String tDesDec(byte[] encrypt, String privateKey) {
		byte[] decrypt = null;
		try {
			Key key = CipherUtil.generateKey("DESede",
					ByteUtils.toBytes(privateKey, 16));
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, key);

			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypt = cipher.doFinal(encrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			return new String(decrypt, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}
}
