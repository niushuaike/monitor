/**
 * Copyright 2016-2017 com.nanf.cross.api
 * All rights reserved.
 * 
 * @project
 * @author jackey
 * @version 1.0
 * @date 2016年11月25日
 */
package com.micropower.manager.common.util;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import java.security.Key;

public class EncryptUtil {

	public static String encryptAES(String in, String key, String iv) throws Exception {

		Key k = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, k, new IvParameterSpec(iv.getBytes()));
		byte[] b = cipher.doFinal(in.getBytes());
		String r0 = Base64.encodeBase64String(b);
		String r1 = encode(r0);
		return r1;
	}

	public static String decryptAES(String in, String key, String iv) throws Exception {

		String t0 = decode(in);
		byte[] bytes = Base64.decodeBase64(t0);
		Key k = new SecretKeySpec(key.getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, k, new IvParameterSpec(iv.getBytes()));
		byte[] ret = cipher.doFinal(bytes);

		return new String(ret, "utf-8");
	}

	private static String encode(String code) {
		code = code.replace("+", "-");
		code = code.replace("/", "_");
		code = code.replace("=", "~");
		return code;
	}

	private static String decode(String code) {
		code = code.replace("-", "+");
		code = code.replace("_", "/");
		code = code.replace("~", "=");
		return code;
	}

	public static void main(String[] args) throws Exception {
		String in = "e8:26bc2a8aa29724db2ae78ee84d7dc1e8:111";
		String key = "96a4a91eb345bdd4";
		String iv = "1122334455667788";
		String token = encryptAES(in, key, iv);
		// String token =
		// "kFW7A5ukJVZfPoMg4gzD0ngkpNUtg+SMswG109Fd2d+I1M2l2y5ujLJrmrM9/FLn7KrzfSkdDhb80I8p8rk8ww==";
		System.out.println(token);
		System.out.println(decryptAES(token, key, iv));

	}
}
