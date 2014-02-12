package utils.dcase.file;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
 
@SuppressWarnings("unchecked")
public class Configuration {
	public Configuration(String fileName){
		configFileName = fileName;
	}
	
	public Configuration(){
		
	}
	
	public void loadConfig(InputStream is) throws IOException{
		properties = new Properties();
		try {
			properties.load(is);
			e = properties.propertyNames();
			variesMap = new HashMap<String, String>();
			System.out.println("*************************************");
			while(e.hasMoreElements()){
				String varName = (String) e.nextElement();
				varName = new String(varName.getBytes("iso-8859-1"),"utf-8");
				String varValue = properties.getProperty(varName, "");
				varValue = new String(varValue.getBytes("iso-8859-1"),"utf-8");
				variesMap.put(varName, varValue);
				System.out.println(varName+" = "+varValue);
			}
			System.out.println("*************************************");
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**
	 * load config file
	 * @param fileName
	 * @throws IOException 
	 */
	public void loadConfig(String fileName) throws IOException{
		this.configFileName = fileName;
		properties = new Properties();
		try {
			properties.load(new FileInputStream(configFileName));
			e = properties.propertyNames();
			variesMap = new HashMap<String, String>();
			System.out.println("*************************************");
			while(e.hasMoreElements()){
				String varName = (String) e.nextElement();
				varName = new String(varName.getBytes("iso-8859-1"),"utf-8");
				String varValue = properties.getProperty(varName, "");
				varValue = new String(varValue.getBytes("iso-8859-1"),"utf-8");
				variesMap.put(varName, varValue);
				System.out.println(varName+" = "+varValue);
			}
			System.out.println("*************************************");
			
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}
	/**
	 * get key's String value 
	 * @return
	 */
	public String getProperty(String key , String defaultValue){
		String tmp = "";
		tmp = variesMap.get(key);
		if(tmp != null && !tmp.trim().equals("")){
			return tmp;
		}else{
			return defaultValue;
		}
	}
	
	/**
	 * get key's int value 
	 * @return
	 */
	public int getProperty(String key , int defaultValue){
		String tmp = "";
		tmp = variesMap.get(key);
		if(tmp != null && !tmp.trim().equals("") && tmp.matches("[0-9]*")){
			return Integer.parseInt(tmp);
		}else{
			return defaultValue;
		}
	}
	
	private  Enumeration e = null; //save the parametersName from config.ini
	private  Map<String, String> variesMap = null; //save the value and name in config.ini 
	private Properties properties = null;
	private  String configFileName = "config.ini";
}
