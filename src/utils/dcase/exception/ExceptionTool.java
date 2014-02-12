package utils.dcase.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionTool {
	public static String getExceptionInfo(Exception e){
		StringWriter sw = new StringWriter();
	    e.printStackTrace(new PrintWriter(sw));
	    return sw.getBuffer().toString();
	}
}
