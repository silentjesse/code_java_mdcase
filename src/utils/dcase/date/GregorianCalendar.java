package utils.dcase.date;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 扩展java.util.GregorianCalendar类
 * 
 * @author victim
 * @version 0.1.3 2008-02-20
 */
public class GregorianCalendar extends java.util.GregorianCalendar {

	private static final long serialVersionUID = 1L;

	/**
	 * 取得当前日期 格式:年-月-日&nbsp;&nbsp;&nbsp;&nbsp;例:1998-02-19
	 * 
	 * @return 当前日期
	 */
	static public String getToday() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH));
	}

	/**
	 * 取得当前年 格式:年
	 * 
	 * @return 当前年
	 */
	static public String getYear() {
		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR) + "";
	}

	/**
	 * 取得当前月
	 * 
	 * @return 当前月
	 */
	static public String getMonth() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		return df.format((currentlyGregorianCalendar
				.get(GregorianCalendar.MONTH) + 1));
	}

	/**
	 * 取得当前日期的后一天 格式:年-月-日&nbsp;&nbsp;&nbsp;&nbsp;例:1998-02-20
	 * 
	 * @return 当前日期的后一天
	 */
	static public String getNextDay() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");
		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		currentlyGregorianCalendar.add(Calendar.DATE, 1);
		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH));
	}

	/**
	 * 取得给定日期 格式:年-月-日&nbsp;&nbsp;&nbsp;&nbsp;例:1998-02-19
	 * 
	 * @return 当前日期
	 */
	static public String getToday(Calendar currentlyCalendar) {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");
		return currentlyCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df
						.format((currentlyCalendar.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyCalendar
						.get(GregorianCalendar.DAY_OF_MONTH));
	}

	/**
	 * 取得当前日期的前一天 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-03-07 12:11:29
	 * 
	 * @return
	 */
	static public String getPerviouseDayTime() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");
		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();

		// 前一天
		currentlyGregorianCalendar.add(Calendar.DATE, -1);

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH))
				+ " "
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.HOUR_OF_DAY))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.MINUTE))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.SECOND));
	}

	/**
	 * 取得当前日期的前一天 格式:年-月-日 &nbsp;&nbsp;&nbsp;&nbsp;例:2008-03-07
	 * 
	 * @return
	 */
	static public String getPerviouseDay() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");
		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();

		// 前一天
		currentlyGregorianCalendar.add(Calendar.DATE, -1);

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH));
	}

	/**
	 * 取得大前天 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-03-07 12:11:29
	 * 
	 * @return
	 */
	static public String getPerviouseTwoDayTime() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");
		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();

		// 前一天
		currentlyGregorianCalendar.add(Calendar.DATE, -2);

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH))
				+ " "
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.HOUR_OF_DAY))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.MINUTE))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.SECOND));
	}

	/**
	 * 取得当前日期时间 格式:年-月-日 小时:分钟:秒.豪秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20
	 * 12:11:29.093
	 * 
	 * @return当前日期时间
	 */
	static public String getDayTime() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");
		DecimalFormat dfMilliSecond = new DecimalFormat("000");

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH))
				+ " "
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.HOUR_OF_DAY))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.MINUTE))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.SECOND))
				+ "."
				+ dfMilliSecond.format(currentlyGregorianCalendar
						.get(GregorianCalendar.MILLISECOND));
	}

	/**
	 * 取得当前日期时间 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20
	 * 12:11:29.093
	 * 
	 * @return当前日期时间
	 */
	static public String getDaySimapleTime() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH))
				+ " "
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.HOUR_OF_DAY))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.MINUTE))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.SECOND));
	}

	/**
	 * 取得当前日期零时 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20 00:00:00
	 * 
	 * @return当前日期时间
	 */
	static public String getDayZeroTime() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH)) + " 00:00:00";
	}

	/**
	 * 取得给定日期时间的后一天 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20
	 * 12:11:29.093
	 * 
	 * @return当前日期时间
	 */
	static public String getNextDaySimapleTime(String strDate) {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		DateFormat dfDate = DateFormat.getDateInstance();
		Date date = new Date();
		try {
			date = dfDate.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		currentlyGregorianCalendar.setTime(date);

		currentlyGregorianCalendar.add(Calendar.DATE, 1);

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH))
				+ " "
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.HOUR_OF_DAY))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.MINUTE))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.SECOND));
	}

	/**
	 * 取得给定的日期时间 格式:年-月-日 小时:分钟:秒.豪秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20
	 * 12:11:29.093
	 * 
	 * @return当前日期时间
	 */
	static public String getDayTime(Calendar calendar) {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");
		DecimalFormat dfMilliSecond = new DecimalFormat("000");

		return calendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((calendar.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(calendar.get(GregorianCalendar.DAY_OF_MONTH))
				+ " "
				+ df.format(calendar.get(GregorianCalendar.HOUR_OF_DAY))
				+ ":"
				+ df.format(calendar.get(GregorianCalendar.MINUTE))
				+ ":"
				+ df.format(calendar.get(GregorianCalendar.SECOND))
				+ "."
				+ dfMilliSecond.format(calendar
						.get(GregorianCalendar.MILLISECOND));
	}

	/**
	 * 取得给定日期零时 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20 00:00:00
	 * 
	 * @return当前日期时间
	 */
	static public String getDayZeroTime(String strDate) {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		DateFormat dfDate = DateFormat.getDateInstance();
		Date date = new Date();
		try {
			date = dfDate.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		currentlyGregorianCalendar.setTime(date);

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH)) + " 00:00:00";
	}

	/**
	 * 取得给定日期最大时 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20 23:59:59
	 * 
	 * @return当前日期时间
	 */
	static public String getDayMaxTime(String strDate) {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		DateFormat dfDate = DateFormat.getDateInstance();
		Date date = new Date();
		try {
			date = dfDate.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		currentlyGregorianCalendar.setTime(date);

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH)) + " 23:59:59";
	}

	/**
	 * 取得当前日期时间 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20
	 * 12:11:29.093
	 * 
	 * @return当前日期时间
	 */
	static public String getDaySimapleTime(Date date) {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		currentlyGregorianCalendar.setTime(date);
		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH))
				+ " "
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.HOUR_OF_DAY))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.MINUTE))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.SECOND));
	}

	// //////////////////////////////////////////////////////月

	/**
	 * 取得当前月的最后一天 格式:年-月 &nbsp;&nbsp;&nbsp;&nbsp;例:2008-03-31
	 * 
	 * 
	 * @return给定日期的该月最后一天
	 */
	static public String getLastDayForMonth() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
	}

	/**
	 * 取得当前月的第一天 格式:年-月 &nbsp;&nbsp;&nbsp;&nbsp;例:2008-03-31
	 * 
	 * 
	 * @return给定日期的该月第一天
	 */
	static public String getFirstDayForMonth() {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
	}

	/**
	 * 取得给定日期的月的最后一天 格式:年-月 &nbsp;&nbsp;&nbsp;&nbsp;例:2008-03-31
	 * 
	 * 
	 * @return给定日期的该月最后一天
	 */
	static public String getLastDayForMonth(String strDate) {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		DateFormat dfDate = DateFormat.getDateInstance();
		Date date = new Date();
		try {
			date = dfDate.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		currentlyGregorianCalendar.setTime(date);

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
	}

	/**
	 * 取得给定日期时间的后一天 格式:年-月-日 小时:分钟:秒&nbsp;&nbsp;&nbsp;&nbsp;例:2008-02-20
	 * 12:11:29.093
	 * 
	 * @return当前日期时间
	 */
	static public String getDaySimapleTime(String strDate) {
		// 格式化月和日为两位(mssql的getDate()函数默认为两位,不足两位前面补零)
		DecimalFormat df = new DecimalFormat("00");

		DateFormat dfDate = DateFormat.getDateInstance();
		Date date = new Date();
		try {
			date = dfDate.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar currentlyGregorianCalendar = GregorianCalendar.getInstance();
		currentlyGregorianCalendar.setTime(date);

		currentlyGregorianCalendar.add(Calendar.DATE, 1);

		return currentlyGregorianCalendar.get(GregorianCalendar.YEAR)
				+ "-"
				+ df.format((currentlyGregorianCalendar
						.get(GregorianCalendar.MONTH) + 1))
				+ "-"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.DAY_OF_MONTH))
				+ " "
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.HOUR_OF_DAY))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.MINUTE))
				+ ":"
				+ df.format(currentlyGregorianCalendar
						.get(GregorianCalendar.SECOND));
	}

	// //////星期
	/**
	 * 取得当前星期的第一天(星期日)
	 */
	static public String getCurrentlyWeekFirstDay() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, -dayOfWeek);
		return GregorianCalendar.getToday(calendar);
	}

	/**
	 * 取得当前星期的最后一天(星期六)
	 */
	static public String getCurrentlyWeekLastDay() {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, 6 - dayOfWeek);
		return GregorianCalendar.getToday(calendar);
	}

	/**
	 * 取得指定日期的那一周的第一天(星期日) 如指定日期格式错误,返回当前周的第一天
	 */
	static public String getWeekFirstDay(String day) {
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		try {
			date = DateFormat.getDateInstance().parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null) {
			calendar.setTime(date);
		}
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, -dayOfWeek);
		return GregorianCalendar.getToday(calendar);
	}

	/**
	 * 取得指定日期的那一周的最后一天(星期六) 如指定日期格式错误,返回当前周的最后一天
	 */
	static public String getWeekLastDay(String day) {
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		try {
			date = DateFormat.getDateInstance().parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null) {
			calendar.setTime(date);
		}
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, 6 - dayOfWeek);
		return GregorianCalendar.getToday(calendar);
	}

	/**
	 * 取得指定日期的前一周的第一天(星期日) 如指定日期格式错误,返回当前周的第一天
	 */
	static public String getPerviousWeekFirstDay(String day) {
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		try {
			date = DateFormat.getDateInstance().parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.add(Calendar.DATE, -7);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, -dayOfWeek);
		return GregorianCalendar.getToday(calendar);
	}

	/**
	 * 取得指定日期的前一周的最后一天(星期六) 如指定日期格式错误,返回当前周的最后一天
	 */
	static public String getPerviousWeekLastDay(String day) {
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		try {
			date = DateFormat.getDateInstance().parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.add(Calendar.DATE, -7);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, 6 - dayOfWeek);
		return GregorianCalendar.getToday(calendar);
	}

	/**
	 * 取得指定日期的后一周的第一天(星期日) 如指定日期格式错误,返回当前周的第一天
	 */
	static public String getNextWeekFirstDay(String day) {
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		try {
			date = DateFormat.getDateInstance().parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.add(Calendar.DATE, 7);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, -dayOfWeek);
		return GregorianCalendar.getToday(calendar);
	}

	/**
	 * 取得指定日期的后一周的最后一天(星期六) 如指定日期格式错误,返回当前周的最后一天
	 */
	static public String getNextWeekLastDay(String day) {
		Calendar calendar = Calendar.getInstance();
		Date date = null;
		try {
			date = DateFormat.getDateInstance().parse(day);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null) {
			calendar.setTime(date);
		}
		calendar.add(Calendar.DATE, 7);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		calendar.add(Calendar.DATE, 6 - dayOfWeek);
		return GregorianCalendar.getToday(calendar);
	}

}
