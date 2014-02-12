package utils.dcase.internet.http;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

import utils.dcase.expression.regular.PatternUtils;

 
 
public class HttpUtils {
	@SuppressWarnings("deprecation")
	public static String getHeader(String httpmsg, String header) throws Exception{
		if(header == null || httpmsg == null){
			throw new Exception(" httpmsg is null or header is null");
		}
		PatternUtils pattern = new PatternUtils();
		String patternStr ="[\\s\\S]*\\s\\s" + header.trim() + ": (.*)\\s\\s[\\s\\S]*"; 
		pattern.init(patternStr);
		String headerValue = pattern.getMessageXML(httpmsg);
		
		return headerValue.trim();
	}
	
	public static String getBody(String httpmsg) throws Exception{
		if(httpmsg == null){
			throw new Exception("httpmsg is null");
		}
		PatternUtils pattern = new PatternUtils();
		//String patternStr = "[\\s|\\S]*\\s\\s\\s\\s([.]{0,"+ contentlength +"})";
		//System.out.println("[\\s|\\S]*\\s\\s\\s\\s([\\s|\\S]{0,"+ contentlength +"})");
		//String patternStr = "[\\s|\\S]*\\s\\s\\s\\s[\\s|\\S]*";
		String patternStr = "[\\s|\\S]*[\\S]{1,}\\s\\s\\s\\s([\\s|\\S]*)";
		//System.out.println("-----++++++++++++++++" + httpmsg.matches(patternStr));
		pattern.init(patternStr);
		String headerValue = pattern.getMessageXML(httpmsg);
		return headerValue;
	}
	
	public static String getBody(DataInputStream dis, String charset, String logPrefix) throws  Exception {
		ByteArrayOutputStream baos = null;
		int bufferSize = 1024*8;
		String body = "";
		int size = 100;
		baos = new ByteArrayOutputStream(); 
		byte[] buffer = new byte[bufferSize];
		int contentlength = -1;
		while((size = dis.read(buffer)) != -1){
			baos.write(buffer,0,size);
			String temp =  baos.toString(charset);
			String contentlengthstr = getHeader(temp, "Content-Length");
			if(contentlengthstr.length() != 0){
				contentlength = Integer.parseInt(contentlengthstr);
			}
			//System.out.println("----------!!" + contentlength);
			if(contentlength != -1){
				body = HttpUtils.getBody(temp);
				if(body.length() >= contentlength ){
					break;
				}
			}
			
		}
		//Log.info(baos.toString(charset), logPrefix);
		baos.close();
		return body;
	}
	
	
	public static String getMsg(DataInputStream dis, String charset, String logPrefix) throws NumberFormatException, UnsupportedEncodingException, IOException, Exception{
		ByteArrayOutputStream baos = null;
		int bufferSize = 1024*8;
		String body = "";
		int size = 100;
		baos = new ByteArrayOutputStream(); 
		byte[] buffer = new byte[bufferSize];
		int contentlength = -1;
		String temp =  "";
		while((size = dis.read(buffer)) != -1){
			baos.write(buffer,0,size);
			temp =  baos.toString(charset);
			String contentlengthstr = getHeader(temp, "Content-Length");
			if(contentlengthstr.length() != 0){
				contentlength = Integer.parseInt(contentlengthstr);
			}
			//System.out.println("----------!!" + contentlength);
			if(contentlength != -1){
				body = HttpUtils.getBody(temp);
				if(body.length() >= contentlength ){
					break;
				}
			}
			
		}
		//Log.info(baos.toString(charset), logPrefix);
		baos.close();
		return temp;
	}


	public static String parseInputBody(Socket client, String charset, String logPrefix) throws Exception {
		
		DataInputStream dis = null;
		dis = new DataInputStream(client.getInputStream());
		dis = new DataInputStream(client.getInputStream());
		String body = "";
		body = getBody(dis, charset, logPrefix);
		return body.trim();
	}


	public static void sentOutputMsg(Socket client, String outStr, String charset) throws IOException {
		DataOutputStream dos = null;
		dos = new DataOutputStream(client.getOutputStream());
		dos.write(outStr.getBytes(charset));
		dos.flush();
	}


	public static void closeSocket(Socket client) throws IOException {
		if(client != null){
			OutputStream output = client.getOutputStream();
			InputStream input = client.getInputStream();
			if(output != null){
				output.close();
			}
			if(input != null){
				input.close();
			}
			if(client != null){
				input.close();
			}
		}
		
	}
	
	public static String getPostParameter(String body,String parameter) throws Exception{
		if(body == null || parameter == null){
			throw new Exception(" body is null or parameter is null");
		}
		
		String value = "";
		parameter = parameter.trim();
		String patternStr =  parameter + "=([^&]*)&.*"  ;
		 
		if(body.toUpperCase().matches(patternStr.toUpperCase())){
			PatternUtils pattern = new PatternUtils();
			pattern.init(patternStr);
			value = pattern.getMessageXML(body);
			return value.trim();
		}
		
		patternStr = ".*&" + parameter.trim()+"=([^&]*)&.*" + "";
		 
		if(body.toUpperCase().matches(patternStr.toUpperCase())){
			PatternUtils pattern = new PatternUtils();
			pattern.init(patternStr);
			value = pattern.getMessageXML(body);
			return value.trim();
		}
		
		patternStr = ".*&" + parameter.trim()+"=([^&]*)" + "";
		 
		if(body.toUpperCase().matches(patternStr.toUpperCase())){
			PatternUtils pattern = new PatternUtils();
			pattern.init(patternStr);
			value = pattern.getMessageXML(body);
			return value.trim();
		}
		
		
		
		
	/*	patternStr =  parameter.trim()+"=([^&]*)&.*";
		if(parameter.matches(patternStr)){
			PatternUtils pattern = new PatternUtils();
			pattern.init(patternStr);
			value = pattern.getMessageXML(body);
			return value;
		}*/
		
		
		return value.trim();
	}
	
	
	public static boolean ishttpFileExist(String contentHost, String prerelativepath,
			String prefilename) throws Exception { 
		String urlPath =  contentHost + "/" + prerelativepath + "/" + prefilename;
		HttpURLConnection   httpConnection   = null;
		long urlFileLength  =0 ;
		long connecttimeout = 5000;//20s连接超时
		long readtimeout = 5000;//5s读取超时
		try{
			urlPath = urlPath.replaceAll("\\\\", "/");
			URL   url   =   new   URL(urlPath);
			 httpConnection   =   (HttpURLConnection)   url.openConnection(); 
	         System.setProperty("sun.net.client.defaultConnectTimeout", Long.toString(connecttimeout));//连接请求30s超时
	         System.setProperty("sun.net.client.defaultReadTimeout", Long.toString(readtimeout));//读取5s超时
	         httpConnection.getInputStream();//取得连接,如果连接超时则在这里便会抛出
	         urlFileLength = httpConnection.getContentLength();
		}catch (Exception e) { 
			throw new Exception("file doesn't exist:" + urlPath);
		}
		if(urlFileLength == 0){
			return false;
		}else{
			return true;
		}
		
	}
	
	
/*	public static void main(String[] args) throws Exception {
		String parameter = "TRANSID=00037660874781678&CMD=DLVRMSG&FET=IVR&NTYPE=ONE2CALL&FROM=6618353334" +
						"&TO=*88812345&CODE=REQUEST&CTYPE=TEXT&CONTENT=*88812345";
		PatternUtils pattern = new PatternUtils();
		//String patternStr = "TRANSID=([^&]*)&.*"; //TRANSID=([^&]*)&.*
		String patternStr = "CMD=([^&]*)&.*"; //TRANSID=([^&]*)&.*
	 
		//pattern.init(patternStr);
		System.out.println(getPostParameter(parameter, "fet")); 
	}*/
	
	/***********************************************************************
	* 文 件 名 : http规范中的content-type
	* <br/>包： utils.dcase.internet.http 
	* <br/>工程: aadcase  
	* <br/>创 建 人： 洪建忠  
	* <br/>日   期： 2012-5-11 下午06:04:15 
	* <br/>描   述： 
	* <br/>福建邮科电信业务部厦门研发中心                                                                                                                                                              
	* <br/>http://www.fsti.com                                              
	* <br/>CopyRright (c) 2011-2011   <br/><br/>
	**********************************************************************/
	public enum ContentType {
		/**
		 * text/plain;charset=UTF-8
		 */
		TEXT_PLAIN("text/plain;charset=UTF-8"),
		
		/**
		 * text/html;charset=UTF-8
		 */
		TEXT_HTML("text/html;charset=UTF-8"),
		
		/**
		 * text/xml;charset=UTF-8
		 */
		TEXT_XML("text/xml;charset=UTF-8"),
		
		/**
		 * application/json;charset=UTF-8
		 */
		JSON("application/json;charset=UTF-8");
		
		
		
		public String value = "";
		
		private ContentType(String value){
			this.value = value;
		}
	}
}
