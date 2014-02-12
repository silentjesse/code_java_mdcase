package utils.dcase.struts20;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;



public class StrutsFile {

	/**
	 * 文件名
	 */
	public String fileName = "";
	
	public String contentType = "";
	/**
	 * 扩展名
	 */
	public String extend = "";
	
	/**
	 * 文件大小
	 */
	public long size = -1;
	
	/**
	 * 域名字
	 */
	public String fieldName = "";
	
	/**
	 * 文件流
	 */
	public File file = null;
	
 
	
	public void save(String destpath) throws IOException{
		if(file != null){
			File destFile = new File(destpath);
			FileUtils.copyFile(file, destFile);
		}else{
			System.out.println("sourcefile is null");
		}
	}
	
	
	

}
