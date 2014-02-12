package utils.dcase.data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DataConvert {
	public static int[] binaryStr2IntArray(String binaryStr) {
		char[] tmp = binaryStr.toCharArray();
		int[] result = new int[tmp.length];
		for (int i = 0; i < tmp.length; i++) {
			result[i] = tmp[i] - 48;
		}
		return result;
	}
	

	// 表示二进制的整型数组 转 十进制整型
	public static long intArray2Int(int[] arInt) {
		long result = 0;
		for (int i = 0; i < arInt.length; i++) {
			if (arInt[i] == 1) {
				result += (long) Math.pow(2, arInt.length - 1 - i);
			}
		}
		return result;
	}
	
	public static Integer[] stringArrayToIntArray(String[] str){
		Integer[] intarray = new Integer[str.length] ;
		for(int i = 0; i < str.length; i ++){
			intarray[i] = Integer.parseInt(str[i]);
		}
		return intarray;
	}


	/**<br/>-------------------------
	 * <br/>功能描述:将四个字节的byte数组转化成int
	 * <br/>-------------------------
	 * <br/>操 作 人:  洪建忠
	 * <br/>-------------------------
	 * <br/>操 作 日 期:  2011-10-18 上午11:02:21
	 * <br/>-------------------------
	 * @param fourBytes
	 * @return
	 * @throws Exception
	 */
	public static int fourByteArrayToInt(byte[] fourBytes) throws Exception {
		if(fourBytes == null || fourBytes.length > 4){
			throw new Exception("first parameter's length must be less than 5");
		}else if(fourBytes.length < 4){
			byte[] tmp = new byte[4];
			for(int i = 0; i < 4; i ++){
				if ( i >= 4 - fourBytes.length){
					tmp[i] = fourBytes[i -(4-fourBytes.length)];
				}else{
					tmp[i] = 0x00;
				}
			}
			fourBytes = tmp;
			
		} 
		return ByteBuffer.wrap(fourBytes).order(ByteOrder.BIG_ENDIAN).getInt();
		//return getINTFromByte(fourBytes);
	}
	
	/**<br/>-------------------------
	 * <br/>功能描述:将little  endian 转化为  big endian
	 * <br/>-------------------------
	 * <br/>操 作 人:  洪建忠
	 * <br/>-------------------------
	 * <br/>操 作 日 期:  2011-10-18 上午11:01:50
	 * <br/>-------------------------
	 * @param b
	 * @return
	 */
	public static byte[] littleEndianToBigEndian(byte[] b){
		return ByteBuffer.wrap(b).order(ByteOrder.LITTLE_ENDIAN).array();
	}
	
	public static byte[] bigEndianToLittleEndian(byte[] b){
		return ByteBuffer.wrap(b).order(ByteOrder.BIG_ENDIAN).array();
	}
	
    /**<br/>-------------------------
     * <br/>功能描述:将byte数组转化为int
     * <br/>-------------------------
     * <br/>操 作 人:  洪建忠
     * <br/>-------------------------
     * <br/>操 作 日 期:  2011-10-18 下午05:05:13
     * <br/>-------------------------
     * @param buffer
     * @return
     */
    public static int getINTFromByte(byte[] buffer)  
    {  
        int a = 0;  
        a = (0xff000000&(((int)buffer[0])<<24)  
            |0x00ff0000&(((int)buffer[1])<<16)  
            |0x0000ff00&(((int)buffer[2])<<8)  
            |0x000000ff&(((int)buffer[3])<<0));  
        return a;  
    }  
  
  
    /**<br/>-------------------------
     * <br/>功能描述:将int 转化为byte数组
     * <br/>-------------------------
     * <br/>操 作 人:  洪建忠
     * <br/>-------------------------
     * <br/>操 作 日 期:  2011-10-18 下午05:04:44
     * <br/>-------------------------
     * @param length
     * @return
     */
    public static byte[] getBytesFromInt(int length)  
    {  
        byte b[] = new byte[4];  
        b[0] = (byte)(length>>24 & 0xFF);  
        b[1] = (byte)(length>>16 & 0xFF);  
        b[2] = (byte)(length>>8 & 0xFF);  
        b[3] = (byte)(length>>0 & 0xFF);  
        return b;             
    }  
    
    public static void printHexString( byte[] b) {    
 	   for (int i = 0; i < b.length; i++) {   
 	     String hex = Integer.toHexString(b[i] & 0xFF);   
 	     if (hex.length() == 1) {   
 	       hex = '0' + hex;   
 	     }   
 	     System.out.print(  hex.toUpperCase() );   
 	   }    
 	}  
 
    
   
	
	 
}
