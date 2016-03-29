package cs636.music.presentation.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import cs636.music.service.*;
import cs636.music.domain.*;

public class DisplayInvoiceController extends HttpServlet implements Controller
{
	private UserServiceAPI userService;
	private String view;
	
	public DisplayInvoiceController(UserServiceAPI userService, String view)
	{
		this.userService = userService;
		this.view = view;
	}
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		// if no user attribute, have them register, then redirect to invoice page
		if(user == null){
			session.setAttribute("nextPageURL", "/invoice.jsp");
			return "/register.jsp";
		}
			 
		CartBean cart = (CartBean) session.getAttribute("cart");
		
		java.util.Date today = new java.util.Date();
		
		Invoice invoice = new Invoice();
		invoice.setUser(user);
		invoice.setInvoiceDate(today);
		invoice.setLineItems(cart.getItems());
		
		session.setAttribute("invoice", invoice);		
		
		return view;
	}
}