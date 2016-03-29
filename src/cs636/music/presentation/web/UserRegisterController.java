package cs636.music.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs636.music.domain.User;
import cs636.music.service.ServiceException;
import cs636.music.service.UserServiceAPI;

public class UserRegisterController extends HttpServlet implements Controller {
	
	private String view;
	private UserServiceAPI userService;
	
	public UserRegisterController(UserServiceAPI userService, String view){
		this.view = view;
		this.userService = userService;
	}
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		String url = "";
		String error=null;
		try {
			HttpSession session = request.getSession();
			String requestURL = request.getServletPath();
			String email = request.getParameter("emailAddress");
			String firstname = request.getParameter("firstName");
			String lastname = request.getParameter("lastName");
			String preUrl = request.getParameter("preUrl");
			String proCode=request.getParameter("proCode");
			String trackNum=request.getParameter("trackNum");
			if (preUrl == null) {
				request.setAttribute("preUrl", requestURL);
			} else {
				request.setAttribute("preUrl", preUrl);
			}
			request.setAttribute("proCode",proCode);
			request.setAttribute("trackNum",trackNum);
            User user=null;
			// if list of products doesn't exist, initialize it,
			// and store it for the remainder of the session
			if(email!=null && firstname!=null && lastname!=null){
				user = userService.getUserInfo(email);
				if(user==null){
				userService.registerUser(firstname, lastname, email);
				 user = userService.getUserInfo(email);
				}
				 if(user==null){
					 error="No registered user with this email ID";
				 }
			}
			if (user != null) {
				
				

				session.setAttribute("user", user);
				url = preUrl;
			} else {
				url = view;
				
				
			}
			request.setAttribute("error", error);

		} catch (ServiceException e) {
			System.out.println("UserLoginController: " + e);
			throw new ServletException(e);
		}

		return url;
	}

}
