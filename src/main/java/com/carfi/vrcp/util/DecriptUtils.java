package com.carfi.vrcp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密算法
 * @author jiangliuhong
 * @CREATEDATE 2016年12月30日
 */
public class DecriptUtils {

	/**
	 * MD5加密
	 * @param input
	 * @return
	 */
	public static String MD5(String input) {
		try {
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(input.getBytes());
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < md.length; i++) {
				String shaHex = Integer.toHexString(md[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 生成随机字符串
	 * @param length
	 */
	public static String genRandomString(int length){
		String str = "abcdefghijklmnopqrestuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<length;i++){
			int num = random.nextInt(str.length());
			sb.append(str.charAt(num));
		}
		return sb.toString();
	}
	
	/**
	 * md5加盐 加密
	 * @param password 原密码
	 * @param number 散列次数
	 * @return
	 */
	public static String Md5Salt(String password,Integer number){
		Md5Hash hash = new Md5Hash(password, genRandomString(5),number);
		return hash.toString();
	}
	/**
	 * md5加盐加密
	 * @param password 原密码
	 * @return
	 */
	public static String Md5Salt(String password){
		return Md5Salt(password,1);
	}
	
}
