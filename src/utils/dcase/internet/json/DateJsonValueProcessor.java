/*
 * 鏂�浠�鍚�: DateJsonValueProcessor.java
 * 鍖咃細 com.fsti.bst.json
 * 宸ョ▼:portal
 * 鍒�寤�浜猴細 zyb
 * 鏃�  鏈燂細 Dec 21, 2009
 * 淇�鏀�浜猴細 
 * 鏃�  鏈燂細 
 * 鎻�  杩帮細 
 * 鐗�鏈�鍙凤細
 * 绂忓缓閭鐢典俊涓氬姟閮ㄥ帵闂ㄧ爺鍙戜腑蹇�                                                                                                                                                                  
 * http://www.fsti.com                                               
 * CopyRright (c) 2009-xxxx: 
 **********************************************************************/
package utils.dcase.internet.json;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * @version Dec 21, 2009
 * @author zyb
 * @since JDK1.5
 */
public class DateJsonValueProcessor implements JsonValueProcessor {

	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	private DateFormat dateFormat;

	/** */
	/**
	 * 鏋勯�鏂规硶.
	 * 
	 * @param datePattern
	 *            鏃ユ湡鏍煎紡
	 */
	public DateJsonValueProcessor(String datePattern) {

		if (null == datePattern)
			dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		else
			dateFormat = new SimpleDateFormat(datePattern);

	}

	/**//*
		 * 锛堥潪 Javadoc锛�
		 * 
		 * @see
		 * net.sf.json.processors.JsonValueProcessor#processArrayValue(java.
		 * lang.Object, net.sf.json.JsonConfig)
		 */
	public Object processArrayValue(Object arg0, JsonConfig arg1) {
		// TODO 鑷姩鐢熸垚鏂规硶瀛樻牴
		return process(arg0);
	}

	/**//*
		 * 锛堥潪 Javadoc锛�
		 * 
		 * @see
		 * net.sf.json.processors.JsonValueProcessor#processObjectValue(java
		 * .lang.String, java.lang.Object, net.sf.json.JsonConfig)
		 */
	public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
		// TODO 鑷姩鐢熸垚鏂规硶瀛樻牴
		return process(arg1);
	}

	private Object process(Object value) {
		return dateFormat.format((Date) value);
	}

}
