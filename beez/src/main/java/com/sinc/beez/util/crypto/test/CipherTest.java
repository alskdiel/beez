package com.sinc.beez.util.crypto.test;

import java.security.Key;

import javax.crypto.Cipher;

import com.sinc.beez.util.ByteUtils;
import com.sinc.beez.util.crypto.CipherUtil;

public class CipherTest {
	private static final String transformation = "DESede/ECB/PKCS5Padding";
	public static void main(String[] args) {
		try {
			Key key = CipherUtil
					.generateKey("DESede",
							ByteUtils.toBytes(
									"696d697373796f7568616e6765656e61696d697373796f75",
									16));
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, key);

			String str = "{\"building_name\":\"CENTRAL\",\"rssi\":-52,\"beacon_id\":\"MiniBeacon-12894\",\"beacon_position\":\"14F-A\",\"beacon_addr\":\"C1:00:47:00:32:5E\",\"beacon_alias\":\"14F-A\"}";
			byte[] plain = str.getBytes();
			byte[] encrypt = cipher.doFinal(plain);
			System.out.println("원문 : "
					+ ByteUtils.toHexString(plain));
			System.out.println("암호 : "
					+ ByteUtils.toHexString(encrypt));

			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decrypt = cipher.doFinal(encrypt);
			System.out.println("복호 : "
					+ ByteUtils.toHexString(decrypt));
			System.out.println(new String(decrypt, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
