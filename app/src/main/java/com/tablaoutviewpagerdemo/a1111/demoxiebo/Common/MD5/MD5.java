package com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.MD5;

import android.text.TextUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类
 * 调用静态方法getMD5String(String)或getMD5String(byte[])得到输入字符串的MD5加密结果
 * 
 * MD5的算法在RFC1321中定义 
 * 在RFC1321中,给出了Test suite用来检验你的实现是否正确: 
 * MD5 ("") = d41d8cd98f00b204e9800998ecf8427e 
 * MD5 ("a") = 0cc175b9c0f1b6a831c399e269772661 
 * MD5 ("abc") = 900150983cd24fb0d6963f7d28e17f72 
 * MD5 ("message_digest") = f96b697d7cb7938d525a2f31aaf161d0 
 * MD5 ("abcdefghijklmnopqrstuvwxyz") = c3fcd3d76192e4007dfb496cca67e13b
 * 
 */
public class MD5 {

	/**
	 * 对输入字符串进行MD5加密,返回加密后的字符串
	 * 
	 * @param source 待加密字符串
	 * @return MD5字符串
	 */
	public static String getMD5String(String source) {
		MessageDigest messageDigest = null;
		StringBuffer md5StrBuff = new StringBuffer();
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(source.getBytes("UTF-8"));
			byte[] byteArray = messageDigest.digest();
			for (int i = 0; i < byteArray.length; i++) {
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
					md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
				} else {
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return md5StrBuff.toString().toUpperCase();
	}
	public static String md5(String string) {
		if (TextUtils.isEmpty(string)) {
			return "";
		}
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest(string.getBytes());
			String result = "";
			for (byte b : bytes) {
				String temp = Integer.toHexString(b & 0xff);
				if (temp.length() == 1) {
					temp = "0" + temp;
				}
				result += temp;
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 对输入字符串进行MD5加密，返回加密后的字符串
	 * 
	 * @param source 待加密字节数组
	 * @return MD5字符串
	 */
	public static String getMD5String(byte[] source) {
		String s = null;
		// 用来将字节转换成16进制表示的字符
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(source);
			// MD5的计算结果是一个128位的长整数
			byte[] tmp = md.digest();
			// 用字节表示就是16个字节
			char[] str = new char[16 * 2];
			// 每个字节用 16 进制表示的话,使用两个字符
			// 所以表示成 16 进制需要 32 个字符
			int k = 0;// 表示转换结果中对应的字符位置
			// 从第一个字节开始,对 MD5 的每一个字节转换成16进制字符的转换
			for (int i = 0; i < 16; i++) {
				// 取第i个字节
				byte byte0 = tmp[i];
				// 取字节中高4位的数字转换
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				// >>> 为逻辑右移,将符号位一起右移
				// 取字节中低4位的数字转换
				str[k++] = hexDigits[byte0 & 0xf];
			}
			s = new String(str);
			return s.toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String args[]) {
		System.out.println(MD5.getMD5String("1234abcD"));
	}
	
}
