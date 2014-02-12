package test.inttest;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import utils.dcase.data.DataConvert;

public class Int {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		  int a = 0xFFFFFFFF;
		 for(int i = 0; i < 32; i++){//2147483647/2147483647
			 a += Math.pow(2, i);
			// System.out.println(a + "_" + i);
		 }
		// System.out.println(a);
		 
		// System.out.println(Math.pow(2, 32) - 1);
		// int b = 0xD3;
		// System.out.println(b);
		// byte[] x = {0x28, 0x00,0x00,0x00, 127};
		// System.out.println(fourByteArrayToInt(x, false));
		/* byte[] u = {
		  0x0B, 0x31, 0x38, 0x39, 0x35, 0x32, 0x30,
         0x30, 0x37, 0x34, 0x38, 0x32, 0xFC, 0xD3, 0x79, 0x48, 0x67,0x8d, 0x12, 0x00,
         0x00, 0x56, 0x3F, 0x09, 0x15, 0x0E, 0x1F, 0x29, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
         0x00, 0x00, 0x00, 0x00};*/
		 //System.out.println(   Byte.valueOf("127"));
		 
		// byte x = 0xFF;
		 
		// System.out.println(Long.toBinaryString(-1));
		 
		 //System.out.println(Integer.toHexString(-1));
		// int i = 0xffffffff;
		// System.out.println(i);
		  
		 //System.out.println(Byte.parseByte("13459265221"));
		 
		 
		// System.out.println(DataConvert.getBytesFromInt("13459265221".length())[3]);
		 
		// System.out.println(DataConvert.fourByteArrayToInt(DataConvert.getBytesFromInt(13459265221)));
		 
		// System.out.println(0xffffffff);
		 
		byte[] b = new byte[]{-1 };
		
		System.out.println(DataConvert.fourByteArrayToInt(b));
		 
	}
	public static int fourByteArrayToInt(byte[] fourBytes, boolean big_Endian) throws Exception {
		if(fourBytes == null || fourBytes.length > 4){
			throw new Exception("first parameter's length must be less than 5");
		}
		//ByteBuffer.wrap( array ).order( ByteOrder.LITTLE_ENDIAN ).
		if(!big_Endian){
			return ByteBuffer.wrap(fourBytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
		}else{
			return ByteBuffer.wrap(fourBytes).order(ByteOrder.BIG_ENDIAN).getInt();
		} 
	}
}
