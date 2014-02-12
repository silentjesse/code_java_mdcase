package utils.akn.mvc.struts20;

 
import org.apache.log4j.Logger;
 
import utils.dcase.exception.ExceptionTool;
import utils.dcase.file.Configure;
public class ActionBaseOnIOC extends utils.dcase.struts20.ActionBaseOnIOC  {
	 
	private static final long serialVersionUID = 1L;
	/**
	 * print info to log file
	 */
	private Logger loginfo = Logger.getLogger("info");
	private Logger logerror = Logger.getLogger("error");
	private Logger logconsole = Logger.getLogger("console");
	protected String username = "";
	protected String contentHost = "";
	protected String principal = "";
	protected String remoteHost = "";
	/**
	 *print the user login information 
	 */
	public void printLoginInfo(String moduleName){ 
		//printLoginInfo("add Media");
		logInfo("user:" + username + "][IP:" + remoteHost + "][is accessing][module:" + moduleName);
	}
	
	public void init(){
		if(username == null || username.trim().length() == 0){
			username = (String)request.getSession().getAttribute("username");// get user name from session
			remoteHost = request.getRemoteHost();
			contentHost = Configure.get("contentHost", "http://127.0.0.1:8080/");
			principal = Configure.get("principal", "Jesse");
		}
		
	}
	
	
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContentHost() {
		return contentHost;
	}

	public void setContentHost(String contentHost) {
		this.contentHost = contentHost;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
}
