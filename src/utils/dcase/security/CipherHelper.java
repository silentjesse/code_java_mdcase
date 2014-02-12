package utils.dcase.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

////import org.apache.log4j.Logger;

//import poson.ecss.util.debug.Debugger;

/**
 * Description: 锟结供一些锟接斤拷锟杰的帮拷锟斤拷<br>
 * Title: 锟铰斤拷锟斤拷锟斤拷锟斤拷锟较客凤拷锟斤拷锟斤拷锟斤拷目<br>
 * Copyright: Copyright (c) poson 锟斤拷权<br>
 * 
 * @author Zhao Shanfu<br>
 * @version 1.0
 */
public class CipherHelper {

	//private static Logger logger = Logger.getLogger(CipherHelper.class);
	
	public static final int ENCRYPT_MODE = 1;//3DES锟斤拷锟斤拷模式
	public static final int DECRYPT_MODE = 2;//3DES锟斤拷锟斤拷模式

	/**
	 * 使锟斤拷sun锟斤拷司锟斤拷jce锟斤拷全锟姐法
	 */
	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
	}

	/**
	 * 锟斤拷锟斤拷使锟斤拷
	 * 
	 * @param args
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException,
			UnsupportedEncodingException {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		String inStr = "1sdfdafdsf锟揭讹拷哦锟斤拷锟斤拷"; // 要锟斤拷锟杰碉拷锟街凤拷
//		byte[] keyBytes = "this is a 24 byte key !!".getBytes();
		String key = "this is a 24 byte key !!";
//		final byte[] keyBytes = {0x11, 0x22, 0x4F, 0x58, (byte)0x88, 0x10, 0x40, 0x38
//                , 0x28, 0x25, 0x79, 0x51, (byte)0xCB, (byte)0xDD, 0x55, 0x66
//                , 0x11, 0x22, 0x4F, 0x58, (byte)0x88, 0x10, 0x40, 0x38};	//24锟街节碉拷锟斤拷钥

		String hex = tripleDES(1, inStr, key);
		String outStr = tripleDES(2, hex, key);
		System.out.println("锟斤拷锟斤拷前:" + inStr);
		System.out.println("锟斤拷锟杰猴拷锟绞拷锟斤拷锟狡ｏ拷:" + hex);
		System.out.println("锟斤拷锟杰猴拷" + outStr);
	}
	
	/**
	 * 锟斤拷锟斤拷JCE实锟斤拷3DES锟姐法
	 * @param mode 锟斤拷锟杰伙拷锟角斤拷锟斤拷
	 * @param inStr 要锟斤拷锟杰伙拷锟竭斤拷锟杰碉拷锟斤拷锟�
	 * @param key 24锟斤拷锟街节碉拷锟斤拷钥
	 * @return 锟斤拷锟斤拷晒锟斤拷锟斤拷蚍祷丶锟斤拷芑锟斤拷呓锟斤拷芎锟斤拷锟街凤拷锟斤拷锟津，凤拷锟斤拷null
	 */
	public static String tripleDES(int mode, String inStr, String key) {
		String outStr = null;
		byte[] inBytes = null;
		
		if(mode == ENCRYPT_MODE) {
			try {
				inBytes = inStr.getBytes("UTF-8");
				outStr = byte2hex(encode(inBytes, "DESede", key.getBytes()));
			} catch (UnsupportedEncodingException e) {
				
			}
		}
		if(mode == DECRYPT_MODE) {
			try {
				inBytes = hex2byte(inStr);
				outStr = new String(decode(inBytes, "DESede", key.getBytes()), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				
			}
		}
		return outStr;
	}
	
	/**
	 * 锟斤拷息摘要锟斤拷使锟斤拷algorithm摘要锟姐法锟斤拷inputStr锟斤拷锟斤拷锟斤拷息摘要锟斤拷支锟斤拷MD5锟斤拷SHA-1锟姐法
	 * 
	 * @param inputBytes
	 * @param algorithm
	 * @return 锟缴癸拷锟斤拷锟斤拷锟斤拷摘要锟街凤拷锟斤拷锟津，凤拷锟斤拷null
	 */
	public static String digest(byte[] inputBytes, String algorithm) {
		String outputStr = null;
		try {
			MessageDigest alg = MessageDigest.getInstance(algorithm);
			alg.update(inputBytes);
			byte[] digest = alg.digest();
			outputStr = byte2hex(digest);
		} catch (NoSuchAlgorithmException ex) {
//			logger.error("没锟斤拷锟斤拷锟斤拷锟姐法锟斤拷" + algorithm);
//			Debugger.output(ex, logger);
		}
		return outputStr;
	}

	/**
	 * 锟街革拷锟街凤拷
	 * 
	 * @param input 要锟街革拷锟斤拷址锟�
	 * @param delimeter 锟街革拷锟�
	 * @return
	 */
	public static String[] split(String input, String delimeter) {

		List temp = new ArrayList();
		int i = 0;
		do {
			int l = input.indexOf(delimeter);
			if (l < 0) {
				break;
			}
			String s = input.substring(0, l);
			temp.add(s);
			i = l + delimeter.length();
			input = input.substring(i);
		} while (input.indexOf(delimeter) >= 0);

		temp.add(input);
		Object[] temp1 = temp.toArray();
		String[] output = new String[temp1.length];
		System.arraycopy(temp1, 0, output, 0, temp1.length);
		return output;

	}

	/**
	 * 锟斤拷algorithm锟姐法锟斤拷key锟斤拷inputStr锟斤拷锟叫硷拷锟斤拷
	 * 
	 * @param input 要锟斤拷锟杰碉拷锟街斤拷锟斤拷锟斤拷
	 * @param algorithm 要使锟矫的硷拷锟斤拷锟姐法锟斤拷支锟斤拷DES,DESede,Blowfish,HmacMD5,HmacSHA1
	 * @param key 锟斤拷钥
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @return 锟斤拷锟杰成癸拷锟斤拷锟斤拷锟截硷拷锟杰猴拷锟斤拷纸锟斤拷锟斤拷椋拷锟斤拷颍锟斤拷锟絥ull
	 */
	public static byte[] encode(byte[] input, String algorithm, byte[] key) {
		// Security.addProvider(new com.sun.crypto.provider.SunJCE());
		byte[] output = null;
		try {
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, algorithm));
			output = cipher.doFinal(input);
		} catch (NoSuchAlgorithmException ex) {
	//		logger.error("没锟斤拷锟斤拷锟斤拷锟姐法锟斤拷" + algorithm);
	//		Debugger.output(ex, logger);
		} catch (NoSuchPaddingException ex) {
	//		Debugger.output(ex, logger);
		} catch (InvalidKeyException ex) {
	//		logger.error("锟斤拷钥锟斤拷锟斤拷");
	//		Debugger.output(ex, logger);
		} catch (IllegalStateException ex) {
	//		Debugger.output(ex, logger);
		} catch (IllegalBlockSizeException ex) {
	//		Debugger.output(ex, logger);
		} catch (BadPaddingException ex) {
	//		Debugger.output(ex, logger);
		}

		return output;
	}

	/**
	 * 锟斤拷algorithm锟姐法锟斤拷key锟斤拷inputStr锟斤拷锟叫斤拷锟斤拷
	 * 
	 * @param algorithm 要使锟矫的斤拷锟斤拷锟姐法锟斤拷支锟斤拷DES,DESede,Blowfish,HmacMD5,HmacSHA1
	 * @param inputStr 要锟斤拷锟杰碉拷锟街斤拷锟斤拷锟斤拷
	 * @param key 锟斤拷钥
	 * @return 锟斤拷锟杰成癸拷锟斤拷锟斤拷锟截斤拷锟杰猴拷锟斤拷纸锟斤拷锟斤拷椋拷锟斤拷颍锟斤拷锟絥ull
	 */
	public static byte[] decode(byte[] input, String algorithm, byte[] key) {
		byte[] output = null;
		try {
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, algorithm));
			output = cipher.doFinal(input);
		} catch (NoSuchAlgorithmException ex) {
		//	logger.error("没锟斤拷锟斤拷锟斤拷锟姐法锟斤拷" + algorithm);
//			Debugger.output(ex, logger);
		} catch (NoSuchPaddingException ex) {
//			Debugger.output(ex, logger);
		} catch (InvalidKeyException ex) {
		//	logger.error("锟斤拷钥锟斤拷锟斤拷");
//			Debugger.output(ex, logger);
		} catch (IllegalStateException ex) {
//			Debugger.output(ex, logger);
		} catch (IllegalBlockSizeException ex) {
//			Debugger.output(ex, logger);
		} catch (BadPaddingException ex) {
//			Debugger.output(ex, logger);
		}

		return output;
	}

	/**
	 * 锟斤拷锟斤拷锟斤拷转十锟斤拷锟斤拷锟斤拷址锟矫恳伙拷锟斤拷纸锟阶獇位十锟斤拷锟斤拷锟斤拷址锟�
	 * 
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int i = 0; i < b.length; i++) {
			stmp = Integer.toHexString(b[i] & 0XFF);
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	/**
	 * 十锟斤拷锟斤拷锟阶拷纸锟斤拷锟斤拷锟�
	 * 
	 * @param inputStr
	 * @return
	 */
	public static byte[] hex2byte(String hex) throws IllegalArgumentException {
		if (hex.length() % 2 != 0) {
			throw new IllegalArgumentException();
		}
		if (hex.startsWith("0x")) {
			hex = hex.substring(2);
		}
		char[] arr = hex.toCharArray();
		byte[] b = new byte[hex.length() / 2];
		for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
			String swap = "" + arr[i++] + arr[i];
			int byteint = Integer.parseInt(swap, 16) & 0xFF;
			b[j] = new Integer(byteint).byteValue();
		}
		return b;
	}
}
