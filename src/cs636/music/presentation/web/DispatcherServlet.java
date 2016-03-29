package cs636.music.presentation.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs636.music.config.MusicSystemConfig;
import cs636.music.service.UserServiceAPI;

// like Spring MVC DispatcherServlet and its config file, but simpler.
// This servlet is handling the student pages of the pizza project,
// calling on various controllers, one for each student page.
// Note that all the jsp filenames (for views) are in this file, not
// in the controllers themselves.  Each controller is set up
// here and given its forward-to URLs in its constructor.

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 3971217231726348088L;
	private static UserServiceAPI userService;

	// The controllers, one per student page
	private static Controller displayProductController;
	private static Controller displayCatalogController;
	private static Controller displayCartController;
	private static Controller userLoginController;
	private static Controller checkOutController;
	private static Controller userRegisterController;
	private static Controller listenController;
	private static Controller logoutController;
		
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
				
		userService = MusicSystemConfig.getUserService();
		// create all the controllers and their forward URLs
		
		displayProductController = new DisplayProductController(userService,"/WEB-INF/jsp/displayProduct.jsp");
		displayCatalogController = new DisplayCatalogController(userService,"/WEB-INF/jsp/catalog.jsp");
		userLoginController=new UserLoginController(userService,"/WEB-INF/jsp/Login.jsp");
		userRegisterController=new UserRegisterController(userService,"/WEB-INF/jsp/register.jsp");
		checkOutController=new CheckOutController(userService,"/WEB-INF/jsp/orderconfirmation.jsp");
		listenController=new ListenController(userService,"/WEB-INF/jsp/userWelcome.jsp");
		logoutController=new LogoutController("/welcome.jsp");
		displayCartController = new DisplayCartController(userService);
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
		String requestURL = request.getServletPath();
		
		boolean haslog = (request.getSession().getAttribute("log")
				!= null);
		if(haslog==false){
		request.getSession().setAttribute("log",0);
		}
		System.out.println("DispatcherServlet: requestURL = " + requestURL);
		// At studentWelcome, the user gets a StudentBean.
		// If it's not there for subsequent pages, hand the request to
		// studentWelcome. Having the bean is like being "logged in".
		boolean hasBean = (request.getSession().getAttribute("cart")
				!= null);
		if(hasBean==false)
		{
			CartBean cart = new CartBean();
			request.getSession().setAttribute("cart", cart);
		}
		boolean hasUser = (request.getSession().getAttribute("user")
				!= null);

		// Dispatch to the appropriate Controller, which will determine
		// the next URL to use as well as do its own actions.
		// The URL returned by handleRequest will be a servlet-relative URL, 
		// like /WEB-INF/jsp/foo.jsp (a view) 
		// or /something.html (for a controller).
		// Note that although resources below /WEB-INF are inaccessible
		// to direct HTTP requests, they are accessible to forwards
		String forwardURL = null; 
		if (requestURL.equals("/welcome.html")){
			forwardURL = "/welcome.jsp"; // no controller needed
		}else if (requestURL.equals("/logout.html")){
			forwardURL = logoutController.handleRequest(request, response); // no controller needed
	        // test for bean, and if not there, send user to student welcome page
		}
		
		else if (requestURL.equals("/userWelcome.html")){  
			forwardURL = "/WEB-INF/jsp/userWelcome.jsp";
		}else if (requestURL.equals("/displayProduct.html")){
			forwardURL = displayProductController.handleRequest(request, response);
		}else if (requestURL.equals("/catalog.html")){
			forwardURL = displayCatalogController.handleRequest(request, response); 
		}else if(requestURL.startsWith("/displayCart.html")){
			forwardURL = displayCartController.handleRequest(request, response);			
		}else if (requestURL.equals("/register.html")){
			forwardURL = userRegisterController.handleRequest(request, response); // no controller needed
			if(!forwardURL.equals("/WEB-INF/jsp/register.jsp")){
				requestURL=forwardURL;
			}
		}
		
		else if (requestURL.equals("/login.html")|| !hasUser){
			forwardURL = userLoginController.handleRequest(request, response); // no controller needed
	        // test for bean, and if not there, send user to student welcome page
			if(!forwardURL.equals("/WEB-INF/jsp/Login.jsp")){
				requestURL=forwardURL;
			}
		}
		else if (requestURL.equals("/checkout.html")){
			forwardURL = checkOutController.handleRequest(request, response); // no controller needed
	        // test for bean, and if not there, send user to student welcome page
			}
		else if (requestURL.equals("/listen.html")){
			forwardURL = listenController.handleRequest(request, response);
			// no controller needed
	        // test for bean, and if not there, send user to student welcome page
			requestURL=forwardURL;
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
