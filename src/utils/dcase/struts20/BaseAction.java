package utils.dcase.struts20;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.dcase.internet.http.HttpUtils;
import utils.dcase.internet.json.JsonUtil;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
 
	private static final long serialVersionUID = -6541797311820686233L;
	
	protected HttpServletRequest request = null;
	protected  HttpServletResponse response = null;
	
	protected Map<String, Object> map = null;
	protected int pageNo = 1;
	protected int pageSize = 10;
	/**
	 * dispatch to department list page
	 */
	protected final String PAGE_INDEX = "pageindex";
	
	/**
	 * dispatch to add page
	 */
	protected final String PAGE_ADD = "pageadd";
	
	/**
	 * dispatch to update page
	 */
	protected final String PAGE_UPDATE = "pageupdate";
	
	
	public int getPageNo() {
		return pageNo;
	}
 

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

	/**  
	 * put key-value into json map 
	 * @author JZ.Hunt 
	 * @date 2012-5-4 下午06:02:54
	 * @param key
	 * @param value
	 * @return void
	 */
	protected void putIntoJsonMap(String key, Object value) {
		if(map == null){
			map = new HashMap<String, Object>();
		}
		map.put(key, value);
	}
	
	/**  
	 *  out put json map 
	 * @author JZ.Hunt 
	 * @date 2012-5-4 下午06:02:21
	 * @param json
	 * @return void
	 */
	protected void outPrintJson(Map<String, Object> json){ 
		try{
			outPrint(JsonUtil.mapToJson(json), HttpUtils.ContentType.JSON); 
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 *  out put json map
	 * @author JZ.Hunt 
	 * @date 2012-5-4 下午05:59:07
	 * @throws Exception
	 * @return void
	 */
	protected void outPrintJson() throws Exception{
		if(map == null || map.size() == 0){
			throw new Exception("json map is null or size is 0");
		}
		outPrint(JsonUtil.mapToJson(map), HttpUtils.ContentType.JSON);
	}
	 
	/**  
	 *  response a string to client  
	 * @author JZ.Hunt 
	 * @date 2012-5-11 下午06:11:48
	 * @param str
	 * @param contentType
	 * @throws IOException
	 * @return void
	 */
	public void outPrint(String str, HttpUtils.ContentType contentType) throws IOException{
		try {
			if(contentType == null ){
				contentType = HttpUtils.ContentType.TEXT_PLAIN;
			}
			response.setContentType(contentType.value);
			response.getWriter().print(str);
			response.setContentLength(str.length());
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-store");
			response.setCharacterEncoding("utf-8");
			
			flash();
		} catch (IOException e) {
			throw e;
		}
	}
	
	/**  
	 *  flash anything in cache 
	 * @author JZ.Hunt 
	 * @date 2012-5-4 下午06:09:01
	 * @throws IOException
	 * @return void
	 */
	protected void flash() throws IOException{
		
		response.getWriter().flush();
	}
}
