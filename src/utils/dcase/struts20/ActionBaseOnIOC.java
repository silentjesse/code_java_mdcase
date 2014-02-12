package utils.dcase.struts20;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
import org.apache.log4j.Logger;
 import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
 
public class ActionBaseOnIOC extends BaseAction implements 
		ServletRequestAware, ServletResponseAware {
	private static final long serialVersionUID = -3563720317447401133L; 
	protected transient Logger logger = Logger.getLogger(this.getClass());
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;

	}


	
	 
	
	
}
