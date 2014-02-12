package utils.dcase.security;

/**
 * Description: base64����ʵ�֡������poson.ecss.webservice.failure.util���п�����4<br>
 * Title: �½��������Ͽͷ�������Ŀ<br>
 * Copyright: Copyright (c) poson ��Ȩ<br>
 * @author Zhao Shanfu<br>
 * @version 1.0
 */
public class Base64Crypt {

//	public static String encode(String data) {
//		String str = getString(encode(getBinaryBytes(data)));
//
//		int len = str.length();
//		char[] ch = new char[len];
//		for (int i = len - 1, j = 0; i >= 0; i--, j++) {
//			ch[j] = str.charAt(i);
//
//		}
//		String newStr1 = new String(ch);
//		int k = newStr1.lastIndexOf("=");
//		String newStr2 = newStr1.substring(k + 1);
//		return newStr2;
//	}

	public static byte[] encode(byte[] data) {
		int c;
		int len = data.length;
		StringBuffer ret = new StringBuffer(((len / 3) + 1) * 4);
		for (int i = 0; i < len; ++i) {
			c = (data[i] >> 2) & 0x3f;
			ret.append(cvt.charAt(c));
			c = (data[i] << 4) & 0x3f;
			if (++i < len) {
				c |= (data[i] >> 4) & 0x0f;

			}
			ret.append(cvt.charAt(c));
			if (i < len) {
				c = (data[i] << 2) & 0x3f;
				if (++i < len) {
					c |= (data[i] >> 6) & 0x03;

				}
				ret.append(cvt.charAt(c));
			} else {
				++i;
				ret.append((char) fillchar);
			}

			if (i < len) {
				c = data[i] & 0x3f;
				ret.append(cvt.charAt(c));
			} else {
				ret.append((char) fillchar);
			}
		}

		return (getBinaryBytes(ret.toString()));
	}
	
	public static String encode2Str(byte[] data) {
		int c;
		int len = data.length;
		StringBuffer ret = new StringBuffer(((len / 3) + 1) * 4);
		for (int i = 0; i < len; ++i) {
			c = (data[i] >> 2) & 0x3f;
			ret.append(cvt.charAt(c));
			c = (data[i] << 4) & 0x3f;
			if (++i < len) {
				c |= (data[i] >> 4) & 0x0f;

			}
			ret.append(cvt.charAt(c));
			if (i < len) {
				c = (data[i] << 2) & 0x3f;
				if (++i < len) {
					c |= (data[i] >> 6) & 0x03;

				}
				ret.append(cvt.charAt(c));
			} else {
				++i;
				ret.append((char) fillchar);
			}

			if (i < len) {
				c = data[i] & 0x3f;
				ret.append(cvt.charAt(c));
			} else {
				ret.append((char) fillchar);
			}
		}

		return ret.toString();
	}

//	public static String decode(String data) {
//		int len = data.length();
//		char[] ch = new char[len];
//		for (int i = len - 1, j = 0; i >= 0; i--, j++) {
//			ch[j] = data.charAt(i);
//		}
//		String str = new String(ch);
//
//		return (getString(decode(getBinaryBytes(str))));
//	}

	public static byte[] decode(byte[] data) {
		int c;
		int c1;
		int len = data.length;
		StringBuffer ret = new StringBuffer((len * 3) / 4);
		for (int i = 0; i < len; ++i) {
			c = cvt.indexOf(data[i]);
			++i;
			c1 = cvt.indexOf(data[i]);
			c = ((c << 2) | ((c1 >> 4) & 0x3));
			ret.append((char) c);
			if (++i < len) {
				c = data[i];
				if (fillchar == c) {
					break;
				}

				c = cvt.indexOf((char) c);
				c1 = ((c1 << 4) & 0xf0) | ((c >> 2) & 0xf);
				ret.append((char) c1);
			}

			if (++i < len) {
				c1 = data[i];
				if (fillchar == c1) {
					break;
				}

				c1 = cvt.indexOf((char) c1);
				c = ((c << 6) & 0xc0) | c1;
				ret.append((char) c);
			}
		}

		return (getBinaryBytes(ret.toString()));
	}
	
	public static String decode2Str(byte[] data) {
		int c;
		int c1;
		int len = data.length;
		StringBuffer ret = new StringBuffer((len * 3) / 4);
		for (int i = 0; i < len; ++i) {
			c = cvt.indexOf(data[i]);
			++i;
			c1 = cvt.indexOf(data[i]);
			c = ((c << 2) | ((c1 >> 4) & 0x3));
			ret.append((char) c);
			if (++i < len) {
				c = data[i];
				if (fillchar == c) {
					break;
				}

				c = cvt.indexOf((char) c);
				c1 = ((c1 << 4) & 0xf0) | ((c >> 2) & 0xf);
				ret.append((char) c1);
			}

			if (++i < len) {
				c1 = data[i];
				if (fillchar == c1) {
					break;
				}

				c1 = cvt.indexOf((char) c1);
				c = ((c << 6) & 0xc0) | c1;
				ret.append((char) c);
			}
		}

		return ret.toString();
	}

	public static String getString(byte[] arr) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			buf.append((char) arr[i]);
		}
		return (buf.toString());
	}

	public static byte[] getBinaryBytes(String str) {
		byte[] b = new byte[str.length()];
		for (int i = 0; i < b.length; ++i) {
			b[i] = (byte) str.charAt(i);
		}
		return (b);
	}

	private static final int fillchar = '=';

	private static final String cvt = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

	+ "abcdefghijklmnopqrstuvwxyz"

	+ "0123456789+/";



	public static void main(String args[]) {
		String str = "http://10.17.37.17:5010/singleloing/return.jsp$1154448212312";
		if (args.length > 0) {
			str = args[0];
		}
		String temp = encode2Str(str.getBytes());
		String temp1 = decode2Str(temp.getBytes());
		
		System.out.println("���� = " + str);
		System.out.println("base64���ܺ� = " + temp);
		System.out.println("base64���ܺ� = " + temp1);
	}
}
