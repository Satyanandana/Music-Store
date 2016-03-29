package cs636.music.presentation.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import cs636.music.service.*;
import cs636.music.domain.*;

public class DisplayProductController extends HttpServlet implements Controller
{
	private UserServiceAPI userService;
	private String view;
	
	public DisplayProductController(UserServiceAPI userService, String view)
	{
		this.userService = userService;
		this.view = view;
	}
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		try{
			String productCode = request.getParameter("productCode");
			
			Product product = userService.getProduct(productCode);
			HttpSession session = request.getSession();
			session.setAttribute("product", product);
			
		}catch(ServiceException e){
			System.out.println("DisplayProductController: " + e);
			throw new ServletException(e);
		}
		return view;
	}
}