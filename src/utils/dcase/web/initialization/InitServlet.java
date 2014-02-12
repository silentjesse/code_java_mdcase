package utils.dcase.web.initialization;

 

import java.io.File;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

import utils.dcase.exception.ExceptionTool;
 
import utils.dcase.file.Configure;

/**
 * this servlet use to load the config from the path parameter "configureFile" config in web.xml  when the web server start
 * @author Jesse
 *
 */
public class InitServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 * load the properties.ini 
	 */
	public void init() throws ServletException {
		super.init();
		try {
			System.out.println("begin to load configure file");
			String currentDirectory = "";
			currentDirectory = this.getServletContext().getRealPath("");
			Configure.init(currentDirectory + File.separatorChar + getInitParameter("configureFile")); //load the properties.ini
			System.out.println("load configure file successfully");
			
			PropertyConfigurator.configure(currentDirectory + File.separatorChar +Configure.get("log4j", "WEB-INF/log4j.ini"));
			System.out.println("load log4j configure file successfully");
		} catch (Exception e) {
			System.out.println(ExceptionTool.getExceptionInfo(e));
		}
		
	}
}
