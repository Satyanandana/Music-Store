package cs636.music.presentation.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.core.SetSupport;

import cs636.music.config.MusicSystemConfig;
import cs636.music.service.AdminServiceAPI;
import cs636.music.service.UserServiceAPI;

// like Spring MVC DispatcherServlet and its config file, but simpler.
// This servlet is handling the student pages of the pizza project,
// calling on various controllers, one for each student page.
// Note that all the jsp filenames (for views) are in this file, not
// in the controllers themselves.  Each controller is set up
// here and given its forward-to URLs in its constructor.

public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 3971217231726348088L;
	private static AdminServiceAPI adminService;

	// The controllers, one per student page
	
	private static Controller adminLoginController;	
	private static Controller allInvoiceController;
	private static Controller allDownloadsController;
	private static Controller invoiceProcessController;
	private static Controller reInitializeController;
	
		
	// Initialization of servlet: runs before any request is
	// handled in the web app. It does PizzaSystemConfig initialization
	// then sets up all the controllers
	@Override
	public void init() throws ServletException {
		System.out.println("Starting dispatcher servlet initialization");
		// If configureServices fails, it logs errors to the tomcat log, 
		// then throws (not caught here), notifying tomcat of its failure,
		// so tomcat won't allow any requests to be processed
		
			try {
				MusicSystemConfig.configureServices();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.err.println(MusicSystemConfig.exceptionReport(e));
				System.exit(1);
			}
				
		adminService = MusicSystemConfig.getAdminService();
		// create all the controllers and their forward URLs
		adminLoginController = new AdminLoginController(adminService,"/WEB-INF/admin/adminLogin.jsp");
		allInvoiceController = new AllInvoiceController(adminService,"/WEB-INF/admin/allInvoices.jsp");
		allDownloadsController = new AllDownloadsController(adminService,"/WEB-INF/admin/downloads.jsp");
		invoiceProcessController = new InvoiceProcessController(adminService,"/WEB-INF/admin/unprocessed.jsp");
		reInitializeController=new ReInitializeController(adminService,"/WEB-INF/admin/adminWelcome.jsp");
		
		
	}
	
	// Called when app server is shutting this servlet down
	// because it is shutting the app down.
	// Since this servlet is in charge of this app, it is
	// the one to respond by shutting down the BL+DAO
	// (the SysTestServlet ignores the shutdown)
	@Override
	public void destroy() {
		System.out.println("DispatcherServlet: shutting down");
		MusicSystemConfig.shutdownServices();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get webapp-specific part of the URL, the part after
		// the context path that identifies the webapp
		String requestURL = request.getRequestURI();
		
		System.out.println("DispatcherServlet: requestURL = " + requestURL);
		// At studentWelcome, the user gets a StudentBean.
		// If it's not there for subsequent pages, hand the request to
		// studentWelcome. Having the bean is like being "logged in".
		
		boolean hasAdmin = (request.getSession().getAttribute("admin")
				!= null);

		// Dispatch to the appropriate Controller, which will determine
		// the next URL to use as well as do its own actions.
		// The URL returned by handleRequest will be a servlet-relative URL, 
		// like /WEB-INF/jsp/foo.jsp (a view) 
		// or /something.html (for a controller).
		// Note that although resources below /WEB-INF are inaccessible
		// to direct HTTP requests, they are accessible to forwards
		String forwardURL = null;
		
		if (requestURL.endsWith("adminWelcome.html")|| !hasAdmin){
			forwardURL = adminLoginController.handleRequest(request, response); // no controller needed
	        // test for bean, and if not there, send user to student welcome page
			if(!forwardURL.equals("/WEB-INF/admin/adminLogin.jsp")){
				requestURL=forwardURL;
			}
		}else if (requestURL.endsWith("/reInitializeDb.html")){
			forwardURL = reInitializeController.handleRequest(request, response); // no controller needed
	        // test for bean, and if not there, send user to student welcome page
				
			}
		
		else if (requestURL.endsWith("/allinvoices.html")){
			forwardURL = allInvoiceController.handleRequest(request, response); // no controller needed
        // test for bean, and if not there, send user to student welcome page
			
		}else if (requestURL.endsWith("/downloads.html")){
			forwardURL = allDownloadsController.handleRequest(request, response); // no controller needed
	        // test for bean, and if not there, send user to student welcome page
				
			}	
	       else if (requestURL.endsWith("/unprocessedinvoices.html")){
		forwardURL = invoiceProcessController.handleRequest(request, response); // no controller needed
        // test for bean, and if not there, send user to student welcome page
			
		}
		else{ 
			throw new ServletException("DispatcherServlet: Unknown servlet path: "+ requestURL);
			//forwardURL=requestURL;
			
		}
		// Here with good forwardURL to forward to
		System.out.println("DispatcherServlet: forwarding to "+ forwardURL);
		RequestDispatcher dispatcher =getServletContext().getRequestDispatcher(forwardURL);
		dispatcher.forward(request, response);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
