package utils.dcase.file;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadManager {
 
	private List<FileItem> formlists = null;
	
	/**
	 * 
	 * @param parameter
	 * @return
	 * 返回非文件域参数
	 */
	public String getParameter(String parameter){
		String fieldName = "";
		String value = null;
		Iterator<FileItem> iter = formlists.iterator();
		while(iter.hasNext()){
			FileItem fileItem = (FileItem) iter.next();
			if(fileItem.isFormField()){
				fieldName = fileItem.getFieldName();
				if(fieldName.equals(parameter.trim())){
					try {
						value = new String(fileItem.getString().getBytes("iso8859_1"),"utf-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		return value;
	}
	public   Integer getParameter(String parameter, int defaultvalue){
		String value = getParameter(parameter);
		if(value == null || value.trim().equals("")){
			value = "0";
		}
		return new Integer(value);
	}
	
	public   String getParameter(String parameter, String defaultvalue){
		String value = getParameter(parameter);
		if(value == null || value.trim().equals("")){
			value = defaultvalue;
		}
		return value;
	}
	
	/**
	 * @param request
	 * 初始化UploadManager
	 */
	@SuppressWarnings("unchecked")
	public   void initializeFactory(HttpServletRequest request){
		ServletFileUpload upload = null;
		DiskFileItemFactory factory = null;
		factory = new DiskFileItemFactory();
		factory.setSizeThreshold(20 * 1024);
		factory.setRepository(factory.getRepository());
		upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(20 * 1024 * 1024);
		try {
			formlists = upload.parseRequest(request);
		} catch (Exception e) {	 
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param remark
	 * @return
	 */
	public List<File>  getFileList(String remark){
		List<File> fileList = new ArrayList<File>();
		Iterator<FileItem> iter = formlists.iterator();
		while(iter.hasNext()){
			FileItem fileItem = (FileItem) iter.next();
			if(!fileItem.isFormField()){ 
				
				File file = new File();
				file.fieldName = fileItem.getFieldName(); 
				file.name = fileItem.getName(); 
				file.size =  fileItem.getSize() ;
				if(file.size == 0){
					continue;
				}
				file.extend = file.name.substring(file.name.lastIndexOf(".")); 
				 
				try {
					file.fileInputStream = fileItem.getInputStream();
				} catch (IOException e) {
					
				}
				fileList.add(file);
			}
		}
		return fileList;
	} 
	/**
	 * @param remark
	 * @return
	 */
	public File  getFile(String fieldName){
		File file = new File();
		Iterator<FileItem> iter = formlists.iterator();
		while(iter.hasNext()){
			FileItem fileItem = (FileItem) iter.next();
			if(!fileItem.isFormField()){
				file.fieldName = fileItem.getFieldName();
				if(!file.fieldName.equals(fieldName)){
					continue;
				}
				file.size =  fileItem.getSize();
				if(file.size == 0){
					file.name = "";
					file.extend = ""; 
				}else{ 
					file.extend = (file.name.substring(file.name.lastIndexOf("."))).toLowerCase();
					try {
						file.fileInputStream = fileItem.getInputStream();
					} catch (IOException e) {}
				 
				
					break;
				}
			}
		} 
		return file;
	}
	
	 
}
