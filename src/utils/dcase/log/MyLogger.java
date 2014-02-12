package utils.dcase.log;


import org.apache.log4j.Logger;
public class MyLogger{
	private  Logger logInfo = null;
	private  Logger logError = null;
	private  Logger logConsole = null;
	public  void init(){
		logInfo = Logger.getLogger("info");
		logError = Logger.getLogger("error");
		logConsole = Logger.getLogger("console");
	}
	
	public static MyLogger getLogger(@SuppressWarnings("rawtypes") Class clazz){
		MyLogger logger = new MyLogger();
		logger.init();
		return logger;
	}
	
	public   void info(String msg, Throwable t){
		logInfo.info(msg, t);
	}
	public   void info(String msg){
		logInfo.info(msg);
	}
	
	public  void error(String msg, Throwable t){
		logError.error( msg, t);
	}
	
	public  void error(String msg){
		logError.error( msg);
	}
	
	public  void console(String msg, Throwable t){
		logConsole.info(  msg, t);
	}
	
	public  void console(String msg){
		logConsole.info(  msg);
	}
	
	public  void destroy(){
		logInfo = null;
		logError = null;
		logConsole = null;
	}
}
