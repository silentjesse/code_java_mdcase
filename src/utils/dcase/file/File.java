package utils.dcase.file;

import java.io.IOException;
import java.io.InputStream;

public class File {
	/**
	 * 文件名
	 */
	public String name = "";
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
	public InputStream fileInputStream = null;
	
	
	
	/**
	 *存储到disk去的文件名 
	 */
	public String fileName = "";
	
	 
	
	
	public void save(String destpath) throws IOException{
		FileOperation.saveFile(fileInputStream, destpath);
	}
	
	
	
}
