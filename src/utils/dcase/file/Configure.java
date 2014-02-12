package utils.dcase.file;

 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import utils.dcase.exception.ExceptionTool;

 
@SuppressWarnings("unchecked")
public class Configure {
	private static Properties properties = new Properties();
 
	private static Map variesMap = null; //save the value and name in properties.ini 
	
	public static boolean synchronizeDowncount = false;
	public static void init(String path){
		InputStream inputStream = null;
		Enumeration e = null; 
		try {
			inputStream=new FileInputStream(path);
			properties.load(inputStream);
		} catch (IOException ex) {
			System.out.println(ExceptionTool.getExceptionInfo(ex));
		}
		e = properties.propertyNames();
		variesMap = new HashMap();
		System.out.println();
		System.out.println("========================================");
		while(e.hasMoreElements()){
			String varName = (String) e.nextElement();
			String varValue = properties.getProperty(varName, "");
			variesMap.put(varName, varValue);
			System.out.println(varName+" = "+varValue);
		}
		System.out.println("***************************************");
		System.out.println();
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String get(String key, String defaultValue){
		if(defaultValue == null){
			defaultValue = "";
		}
		Set set = variesMap.entrySet();
		Iterator it = set.iterator();
		String value = null;
		
		if(key!=null)
		while(it.hasNext()){
			Entry entry = (Entry) it.next();
			if(key.trim().equals(((String)entry.getKey()).trim())){
				if(entry.getValue() == null){
					value = defaultValue;
				}
				value = (String) entry.getValue();
				break;
			}
		}
		if(value == null){
			value = defaultValue;
		}
		return value;
	}
	
	
}
