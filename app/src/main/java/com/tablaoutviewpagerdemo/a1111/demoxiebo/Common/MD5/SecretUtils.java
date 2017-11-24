package com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * des加密解密
 * 
 * @author
 * 
 */
public class SecretUtils {

	private static Key getKey() {
		try {
			return SecretKeyFactory.getInstance("DESede")
					.generateSecret(new DESedeKeySpec("abc123.*abc123.*abc123.*abc123.*".getBytes("UTF8")));
		} catch (InvalidKeyException | InvalidKeySpecException | NoSuchAlgorithmException
				| UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加密String明文输入,String密文输出
	 */
	public static String encrypt(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		try {
			byteMing = strMing.getBytes("UTF8");
			byteMi = getEncCode(byteMing);
			strMi = BASE64.encode(byteMi);
		} catch (Exception e) {
			throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public static String decrypt(String strMi) {
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = BASE64.decode(strMi);
			byteMing = getDesCode(byteMi);
			strMing = new String(byteMing, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
		} finally {
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	private static byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {// 对比DES
			cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, getKey(), SecureRandom.getInstance("SHA1PRNG"));
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	private static byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {// 对比DES
			cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.DECRYPT_MODE, getKey(), SecureRandom.getInstance("SHA1PRNG"));
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	public static String getToken()
	{
		String  k_desc="AaIt5LH6dzeBtvRN9qie3mzAyfwaee3i";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String currDate = sdf.format(new Date());
		String result = SecretUtils.encrypt(currDate + k_desc);
		return result;
	}
}