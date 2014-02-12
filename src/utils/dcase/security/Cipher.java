package utils.dcase.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;

/**
 * Description: 提供3des加解密，base64编码和sha-1消息摘要的帮助方法<br>

 * Copyright: Copyright (c) poson 版权<br>
 * @author Zhao Shanfu<br>
 * @version 1.0
 */
public class Cipher {
	
	public static final int ENCRYPT_MODE = 1;//加密模式
	public static final int DECRYPT_MODE = 2;//解密模式
    
    //private static Logger logger = Logger.getLogger(Cipher.class);
	
	/**
	 * 调用JCE实现3DES算法
	 * @param mode 1:加密, 2:解密
	 * @param inStr 要加密或者解密的数据
	 * @param key 24个字节的密钥
	 * @return 操作成功，则返回加密或者解密后的字符串；否则，返回null
	 */
	public static String tripleDES(int mode, String inStr, String key) {
		if(StringUtils.isBlank(inStr)){
			return "";
		}
		
		String outStr = null;
		byte[] inBytes = null;
		
		if(mode == ENCRYPT_MODE) {//加密
			try {
				inBytes = inStr.getBytes("UTF-8");
				outStr = CipherHelper.byte2hex(CipherHelper.encode(inBytes, "DESede", key.getBytes()));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			//	logger.error("3des加密发生异常", e);
			} catch (Exception e) {
				e.printStackTrace();
			//	logger.error("3des加密发生异常", e);
			}
		}
		if(mode == DECRYPT_MODE) {//解密
			try {
				inBytes = CipherHelper.hex2byte(inStr);
				outStr = new String(CipherHelper.decode(inBytes, "DESede", key.getBytes()), "UTF-8");
			} catch (UnsupportedEncodingException e) {
			//	logger.error("3des解密发生异常", e);
			} catch(IllegalArgumentException ex) {
            //    logger.error("输入参数错误：" + inStr);
            } catch (Exception e) {
            //	logger.error("3des解密发生异常", e);
			}
		}
		return outStr;
	}
	
	/**
	 * 实现SHA-1消息摘要
	 * @param inStr 
	 * @return 成功，返回摘要，失败，返回null
	 */
	public static String sha1(String inStr) {
		String outStr = null;
		try {
			outStr = CipherHelper.digest(inStr.getBytes("UTF-8"), "SHA-1");
		} catch (UnsupportedEncodingException e) {
		//	logger.error("sha1发生异常", e);
		} catch (Exception e) {
		//	logger.error("sha1发生异常", e);
		}
		return outStr;
	}
	
	/**
	 * 实现MD5消息摘要
	 * @param inStr 
	 * @return 成功，返回摘要，失败，返回null
	 */
	public static String md5(String inStr) {
		String outStr = null;
		try {
			outStr = CipherHelper.digest(inStr.getBytes("UTF-8"), "MD5");
		} catch (UnsupportedEncodingException e) {
		//	logger.error("md5发生异常", e);
		} catch (Exception e) {
		//	logger.error("md5发生异常", e);
		}
		return outStr;
	}
	
	/**
	 * 调用sun公司的base64编码实现
	 * @param mode 1:加密, 2:解密
	 * @param inStr 要加密或者解密的数据
	 * @return 操作成功，则返回加密或者解密后的字符串；否则，返回null
	 */
	public static String base64(int mode, String inStr) {
		String outStr = null;
		
		byte[] inBytes = null;
		if(mode == ENCRYPT_MODE) {
			try {
				inBytes  = inStr.getBytes("UTF-8");
//				outStr = new BASE64Encoder().encode(inBytes);
				outStr = Base64Crypt.encode2Str(inBytes);
			} catch (UnsupportedEncodingException e) {
            //    logger.error("不支持的编码：UTF-8", e);
			} catch (Exception e) {
			//	logger.error("base64加密发生异常", e);
			}
		}
		if(mode == DECRYPT_MODE) {
			try {
				outStr = new String(new BASE64Decoder().decodeBuffer(inStr), "UTF-8");
			} catch (UnsupportedEncodingException e) {
           //     logger.error("不支持的编码：UTF-8");
			} catch (IOException e) {
			//	logger.error("base64加密发生IO异常", e);
			} catch (Exception e) {
			//	logger.error("base64解密发生异常", e);
			}
		}
		return outStr;
	}

}
