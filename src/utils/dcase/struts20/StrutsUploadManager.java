package utils.dcase.struts20;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;


public class StrutsUploadManager {
	
	private Map<String, List<StrutsFile>> strtusFileMap = null;
	private MultiPartRequestWrapper multiPartRequest = null;
	public List<StrutsFile> getStrutsFilesbyFieldName(String fieldName){
		if(strtusFileMap == null){
			return null;
		}
		
		return strtusFileMap.get(fieldName);
	}
	
	public List<StrutsFile> getStrutsFilesByFieldNameStartWith(String fieldName){
		 List<StrutsFile> returnList = new ArrayList<StrutsFile>();
		 List<StrutsFile> list = getStrutsFiles();
		 if(list != null && list.size() > 0){
			 for(int index = 0; index < list.size(); index ++){
				 StrutsFile file = list.get(index);
				 if(file.fieldName.startsWith(fieldName)){
					 returnList.add(file);
				 }
			 }
		 }
		return returnList;
	}
	
	
	/**
	 * if this file does not exist then return null
	 * @param fieldName
	 * @return
	 */
	public StrutsFile getStrutsFilebyFieldName(String fieldName){
		if(strtusFileMap == null){
			return null;
		}
		List<StrutsFile> list = strtusFileMap.get(fieldName);
		return (list == null)? null: list.get(0);
	}
	
	
	
	
	public List<StrutsFile> getStrutsFiles(){
		if(strtusFileMap == null){
			return null;
		}
		
		Set<Entry<String, List<StrutsFile>>>  set = strtusFileMap.entrySet();
		Iterator<Entry<String, List<StrutsFile>>> it = set.iterator();
		List<StrutsFile> list = new ArrayList<StrutsFile>();
		while(it.hasNext()){
			Entry<String, List<StrutsFile>> e = it.next();
			List<StrutsFile> listtmp = e.getValue();
			list.addAll(listtmp);
		}
		return list;
	}
	
	
	public List<String> fieldNames(){
		if(strtusFileMap == null){
			return null;
		}
		Set<Entry<String, List<StrutsFile>>>  set = strtusFileMap.entrySet();
		Iterator<Entry<String, List<StrutsFile>>> it = set.iterator();
		List<String> list = new ArrayList<String>();
		while(it.hasNext()){
			Entry<String, List<StrutsFile>> e = it.next();
			String fieldname = e.getKey();
			list.add(fieldname);
		}
		return list;
	}
	
	
	
	
	public void initFactory(HttpServletRequest request) throws Exception{
		if(request instanceof MultiPartRequestWrapper){
			strtusFileMap = new LinkedHashMap<String, List<StrutsFile>>();
			MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) request;
			multiPartRequest = multiWrapper;
			Enumeration<String> fileParameterNames = multiWrapper.getFileParameterNames(); 
			while((fileParameterNames != null && fileParameterNames.hasMoreElements())){
				String fieldName = fileParameterNames.nextElement();
				String contentType[] = multiWrapper.getContentTypes(fieldName); 
				File file[] = multiWrapper.getFiles(fieldName);
				String fileName[] = multiWrapper.getFileNames(fieldName);
				if(file != null && contentType !=null && fileName != null 
						&& file.length == contentType.length && contentType.length == fileName.length){
					List<StrutsFile> fileList = new ArrayList<StrutsFile>();
					for(int i = 0; i  < file.length; i++){
						StrutsFile strutsfile = new StrutsFile();
						File filetmp = file[i]; 
						strutsfile.file = filetmp;
						strutsfile.fieldName = fieldName;
						strutsfile.contentType = contentType[i];
						strutsfile.size = filetmp.length();
						strutsfile.fileName = fileName[i];
						strutsfile.extend = (strutsfile.fileName.substring(strutsfile.fileName.lastIndexOf("."))).toLowerCase();
						fileList.add(strutsfile);
					}
					if(fileList.size() != 0){
						strtusFileMap.put(fieldName, fileList);
					}
				}else{
					throw new Exception("the count of file and contenttype, filename is not equal");
				}
				 
			}
 
		}else{
			throw new Exception("the form parameter of request is not instance of org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper");
		}
	}

	public Map<String, List<StrutsFile>> getStrtusFileMap() {
		return strtusFileMap;
	}


	public MultiPartRequestWrapper getMultiPartRequest() {
		return multiPartRequest;
	}
	
	 
	
	
}
