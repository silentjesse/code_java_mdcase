package utils.dcase.date.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/***********************************************************************
* 文 件 名 : DateFormatUtil.java 
* <br/>包： utils.dcase.date.format 
* <br/>工程: aadcase  
* <br/>创 建 人： 洪建忠  
* <br/>日   期： 2012-5-4 上午09:54:49 
* <br/>描   述： 时间工具
* <br/>福建邮科电信业务部厦门研发中心                                                                                                                                                              
* <br/>http://www.fsti.com                                              
* <br/>CopyRright (c) 2011-2011   <br/><br/>
**********************************************************************/
public class DateFormatUtil {
	 
	/**  
	 *  将某种格式的字符串日期转换成另一种格式的字符串日期 
	 * @author JZ.Hunt 
	 * @date 2012-6-14 下午03:51:26
	 * @param sourcePattern 源格式
	 * @param toPattern 日期格式
	 * @param str
	 * @return
	 * @return String
	 */
	public static String format(String sourcePattern,String toPattern,String str){
		SimpleDateFormat format0=new SimpleDateFormat(sourcePattern);
		SimpleDateFormat format1=new SimpleDateFormat(toPattern);
		
		Date date=new Date();
		try {
			date=format0.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String toStr=format1.format(date);
		return toStr;
	}
	
	/**  
	 *  将某种格式的字符串日期转换成另一种格式的字符串日期 
	 * @author JZ.Hunt 
	 * @date 2012-6-14 下午03:51:26
	 * @param sourcePattern 源格式
	 * @param toPattern 日期格式
	 * @param str
	 * @return
	 * @return String
	 */
	public static String format(PATTERN sourcePattern,PATTERN toPattern,String str){
		SimpleDateFormat format0=new SimpleDateFormat(sourcePattern.value);
		SimpleDateFormat format1=new SimpleDateFormat(toPattern.value);
		
		Date date=new Date();
		try {
			date=format0.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String toStr=format1.format(date);
		return toStr;
	}
	
	
	/**  
	 * 将java.lang.Date对象转换成某种格式的日期字符串
	 * @author JZ.Hunt 
	 * @date 2012-6-14 下午03:53:26
	 * @param date
	 * @param topattern 目标格式
	 * @return
	 * @return String
	 */
	public static String format(Date date,String topattern){
		SimpleDateFormat format=new SimpleDateFormat(topattern);
		String to=format.format(date);
		return to;
	}
	
	/**  
	 *  当前的时区转换为 toTimeZone时区的 topattern字符串时间
	 * @author JZ.Hunt 
	 * @date 2012-12-12 下午2:12:54
	 * @param date
	 * @param topattern
	 * @param toTimeZone  目标时区
	 * @return
	 * @return String
	 */
	public static String format(Date date,String topattern, TimeZone toTimeZone){
		SimpleDateFormat format=new SimpleDateFormat(topattern);
		format.setTimeZone(toTimeZone);
		String to=format.format(date);
		return to;
	}
	
	/**  
	 * 将java.lang.Date对象转换成某种格式的日期字符串
	 * @author JZ.Hunt 
	 * @date 2012-6-14 下午03:53:26
	 * @param date
	 * @param topattern 目标格式
	 * @return
	 * @return String
	 */
	public static String format(Date date,PATTERN topattern){
		SimpleDateFormat format=new SimpleDateFormat(topattern.value);
		String to=format.format(date);
		return to;
	}
	
	
	public static double getLastDay(Calendar calendar){
		double ld=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);   
		return ld;
	}
	public static Date formatStrtoDate(String dateStr,String pattern) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		Date date=null;
		try {
			date = format.parse(dateStr);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}
	
	
	/**  
	 *  将某格式日期字符串转换成Date对象 
	 * @author JZ.Hunt 
	 * @date 2012-6-14 下午03:57:38
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 * @return Date
	 */
	public static Date PaseStrtoDate(String dateStr,String pattern) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		Date date=null;
		try {
			date=format.parse(dateStr);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}
	
	
	/**  
	 *  将某格式日期字符串转换成Date对象 
	 * @author JZ.Hunt 
	 * @date 2012-6-14 下午03:57:38
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 * @return Date
	 */
	public static Date parseStrtoDate(String dateStr,String pattern) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat(pattern);
		Date date=null;
		try {
			date=format.parse(dateStr);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}
	
	
	
	/**  
	 *  将某格式日期字符串转换成Date对象  
	 * @author JZ.Hunt 
	 * @date 2012-6-14 下午03:58:11
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 * @return Date
	 */
	public static Date parseStrtoDate(String dateStr,PATTERN pattern) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat(pattern.value);
		Date date=null;
		try {
			date=format.parse(dateStr);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}
	
	public static String getNextDate(String sourceDate,String srcPattern,String toPattern){
		SimpleDateFormat format=new SimpleDateFormat(srcPattern);
		Date date=null;
		try {
			date=format.parse(sourceDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar c=GregorianCalendar.getInstance();
		c.setTime(date);
		c.add(GregorianCalendar.DAY_OF_MONTH, 1);
		date=c.getTime();
		format.applyPattern(toPattern);
		return format.format(date);
	}
	
	public static Date getNextDate(Date date){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(GregorianCalendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
	
	public static Date dateAdd(Date date, int amount){
		Calendar cl = GregorianCalendar.getInstance();
		cl.setTime(date);
		cl.add(GregorianCalendar.DAY_OF_MONTH, amount);
		return cl.getTime();
	}
	
	public static String dateAdd(String dateStr, String srcPattern,String toPattern, int amount) throws ParseException{
		Calendar cl = GregorianCalendar.getInstance();
		Date date = formatStrtoDate(dateStr, srcPattern);
		cl.setTime(date);
		cl.add(GregorianCalendar.DAY_OF_MONTH, amount);
		return format(cl.getTime(), toPattern);
	}
	
	
	
	
	public static String monthAdd(String dateStr, String srcPattern,String toPattern, int amount) throws ParseException{
		Calendar cl = GregorianCalendar.getInstance();
		Date date = formatStrtoDate(dateStr, srcPattern);
		cl.setTime(date);
		cl.add(GregorianCalendar.MONTH, amount);
		
		return format(cl.getTime(), toPattern);
	}
	
	
	/**
	 * get the first day of the date you  introduct
	 * @return
	 * @throws ParseException 
	 */
	public static Date getFirstDate(Date date ) throws ParseException{ 
		String format = "yyyyMM";
		date = formatStrtoDate( format(date, format) + "01", format + "dd");
		return date;
	}
	public static Date hourAdd(Date date, int amount){
		Calendar cl = GregorianCalendar.getInstance();
		cl.setTime(date);
		cl.add(GregorianCalendar.HOUR_OF_DAY, amount);
		return cl.getTime();
	}
	
	public static Date minuteAdd(Date date, int amount){
		Calendar cl = GregorianCalendar.getInstance();
		cl.setTime(date);
		
		cl.add(GregorianCalendar.MINUTE, amount);
		return cl.getTime();
	}
	/**
	 * @param date2
	 * @param date1
	 * @return date2 - date1
	 */
	public static long datediff(Date date2, Date date1){
		long date2L = date2.getTime();
		long date1L = date1.getTime();
		return (date2L - date1L);
	}
	
	public static String chargeDate(String date){
		String   charge="";
		if(date.length()>12 && date.length()<15){
			 charge=date.substring(0,4)
				+"-"+date.substring(4,6)
				+"-"+date.substring(6,8)+" "+
				date.substring(8,10)+":"
				+date.substring(10,12)+":"+date.substring(10,12);
		}else{
			charge=date.substring(0,date.lastIndexOf("."));
		}
		
		return charge;
	}
	public static String getDate(){
		Calendar ca=Calendar.getInstance();
		ca.add(Calendar.DATE,3);
		String month="";
		String date="";
		if(ca.get(Calendar.MONTH)+1<10){
			month="0"+(ca.get(Calendar.MONTH)+1);
		}else{
			month+=(ca.get(Calendar.MONTH)+1);
		}
		if(ca.get(Calendar.DATE)+1<10){
			date="0"+(ca.get(Calendar.DATE));
		}else{
			date+=(ca.get(Calendar.DATE));
		}
		date=ca.get(Calendar.YEAR)+month+date ;
		return  date;
	}
	public static String nowDateTime() {
		String sResult = "";
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat formatYYYY = new SimpleDateFormat("yyyy");
		sResult += formatYYYY.format(d);
		SimpleDateFormat formatMM = new SimpleDateFormat("MM");
		sResult += "-" + formatMM.format(d);
		SimpleDateFormat formatDD = new SimpleDateFormat("dd");
		sResult += "-" + formatDD.format(d);
		SimpleDateFormat formatHH = new SimpleDateFormat("HH");
		sResult += " " + formatHH.format(d);
		SimpleDateFormat formatmm = new SimpleDateFormat("mm");
		sResult += ":" + formatmm.format(d);
		SimpleDateFormat formatss = new SimpleDateFormat("ss");
		sResult += ":" + formatss.format(d);
		return sResult;
	}
	public static String nowDateTimeMinute() {
		String sResult = "";
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat formatYYYY = new SimpleDateFormat("yyyy");
		sResult += formatYYYY.format(d);
		SimpleDateFormat formatMM = new SimpleDateFormat("MM");
		sResult += "-" + formatMM.format(d);
		SimpleDateFormat formatDD = new SimpleDateFormat("dd");
		sResult += "-" + formatDD.format(d);
		SimpleDateFormat formatHH = new SimpleDateFormat("HH");
		sResult += " " + formatHH.format(d);
		SimpleDateFormat formatmm = new SimpleDateFormat("mm");
		sResult += ":" + formatmm.format(d);
		return sResult.trim();
	}
	
	
	
	 public static String getCurrentTime(String pattern){
		  Date date = new Date();
		  SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		  String time = sdf.format(date);
		  return time;
	  }
	  public static long getCurrentTime(){
		  Date date = new Date();
		  return date.getTime();
	  }
	 
	
	/**  
	 * 用户判断 currentDate 是否处于startDate和endDate之间,如果是返回true,否则返回false
	 * @author JZ.Hunt 
	 * @date 2012-5-4 上午10:55:33
	 * @param currentDate 当前要被比较的时间
	 * @param startDate 开始时间
	 * @param endDate 结束时间
	 * @return boolean
	 */
	public static boolean among(Date currentDate, Date startDate, Date endDate){
		if (currentDate.before(endDate) && currentDate.after(startDate)) {
			return true;
		}
		return false;
	}
	
	/**  
	 * 判断字符串日期是否与某种格式匹配
	 * @author JZ.Hunt 
	 * @date 2012-6-14 下午03:59:29
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @return boolean
	 */
	public static boolean match(String dateStr, PATTERN pattern){
		try {
			parseStrtoDate(dateStr, pattern.value);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	
	/***********************************************************************
	* 文 件 名 : DateFormatUtil.java 
	* <br/>包： utils.dcase.date.format 
	* <br/>工程: aadcase  
	* <br/>创 建 人： 洪建忠  
	* <br/>日   期： 2012-5-4 上午09:46:16 
	* <br/>描   述： 时间pattern
	* <br/>福建邮科电信业务部厦门研发中心                                                                                                                                                              
	* <br/>http://www.fsti.com                                              
	* <br/>CopyRright (c) 2011-2011   <br/><br/>
	**********************************************************************/
	public enum PATTERN{
		/**yyyyMMddHHmmss*/
		PATTERN1("yyyyMMddHHmmss"),
		/**yyyy-MM-dd HH:mm:ss*/
		PATTERN2("yyyy-MM-dd HH:mm:ss"),
		/**yyyy-MM-dd*/
		PATTERN3("yyyy-MM-dd"),
		/**yyyyMMdd*/
		PATTERN4("yyyyMMdd"),
		/**HHmmss*/
		PATTERN5("HHmmss"),
		/**HH:mm:ss*/
		PATTERN6("HH:mm:ss");
		
		public String value = "";
		private PATTERN(String pattern){
			this.value = pattern;
		}
	}
	
	
	
}
 

