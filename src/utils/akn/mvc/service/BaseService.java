package utils.akn.mvc.service;

import org.apache.log4j.Logger;

import utils.dcase.exception.ExceptionTool;

public abstract class BaseService {
	/**
	 * print info to log file
	 */
	private Logger loginfo = Logger.getLogger("info");
	private Logger logerror = Logger.getLogger("error");
	private Logger logconsole = Logger.getLogger("console");
	/**
	 * print info msg
	 * @param msg
	 */
	public void logInfo(Object obj){
		if(obj != null){
			loginfo.info(obj.toString());
		}else{
			loginfo.info(null);
		}
		
	}
	
	/**
	 * print error msg
	 * @param msg
	 */
	public void logError(Object obj){
		if(obj != null){
			logerror.error(obj.toString());
		}else{
			logerror.error(null);
		}
		
	}
	
	
	/**
	 * print console msg
	 * @param msg
	 */
	public void logConsole(Object obj){
		if(obj != null){
			logconsole.info(obj.toString());
		}else{
			logconsole.info(null);
		}
		 
	}
	/**
	 * log the exception stack information into error.log and console
	 * @param e
	 */
	public void logError(Exception e){
		logerror.error(ExceptionTool.getExceptionInfo(e));
	}
	
}
