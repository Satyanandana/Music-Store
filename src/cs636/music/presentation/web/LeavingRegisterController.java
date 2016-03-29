package cs636.music.presentation.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LeavingRegisterController extends HttpServlet implements Controller
{
	private String view;
	
	public LeavingRegisterController(String view)
	{
		this.view = view;
	}
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session = request.getSession();		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		
		UserBean user = (UserBean) session.getAttribute("user");
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmailAddress(emailAddress);
		
		session.setAttribute("user", user);
		
		
		view += session.getAttribute("nextPageURL");
		
		return view;
	}
}