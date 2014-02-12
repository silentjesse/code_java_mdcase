package utils.dcase.internet.http;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
	/**
	 * @param req
	 * @param param
	 * @param defaultValue
	 * @return
	 */
	public static int getParam(HttpServletRequest request, String param, int defaultValue){
		try{
			String value = request.getParameter(param);
			int idx = value.indexOf('#');
			if(idx!=-1)
				value = value.substring(0,idx);
			return Integer.parseInt(value);
		}catch(Exception e){}
		return defaultValue;
	}
	
	/**
	 * @param req
	 * @param param
	 * @param defaultValue
	 * @return
	 */
	public static String getParam(HttpServletRequest request, String param, String defaultValue){
		String value = request.getParameter(param);
		if(value==null||value.length()==0){
			return defaultValue;
		}else{
			if(request.getMethod()!=null &&request.getMethod().equals("GET")){
				try {
					return new String(value.getBytes("ISO8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {	
					e.printStackTrace();
					return defaultValue;
				}
			}else{
				return value;
			}
		}
	
	}
}
