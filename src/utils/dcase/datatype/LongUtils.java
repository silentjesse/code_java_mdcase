package utils.dcase.datatype;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class LongUtils {
	public static Integer LongToInt(Long parameter){
		long sizel = parameter;
		String sizelStr = Long.toString(sizel);
		int sizeI = Integer.parseInt(sizelStr);
		return sizeI;
	}
	
	
}
