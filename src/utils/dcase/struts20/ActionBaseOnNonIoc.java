package utils.dcase.struts20;

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

 
import com.opensymphony.xwork2.ActionContext;
 

public class ActionBaseOnNonIoc extends BaseAction {
	 
	private static final long serialVersionUID = -5465087641768646997L;
	protected ActionContext context = ActionContext.getContext();
 
	public ActionBaseOnNonIoc(){
		request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);   
		response = (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);  
	}
	
}
