package cs636.music.presentation.web;

import java.io.*;
import java.util.Set;

import javax.servlet.*;
import javax.servlet.http.*;

import cs636.music.service.*;
import cs636.music.domain.*;

public class DisplayCatalogController implements Controller
{
	private String view;
	private UserServiceAPI userService;
	
	public DisplayCatalogController(UserServiceAPI userService, String view){
		this.view = view;
		this.userService = userService;
	}
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		try{
			HttpSession session = request.getSession();
			
			// if list of products doesn't exist, initialize it,
			// and store it for the remainder of the session
			if(session.getAttribute("products") == null){
				Set<Product> products = userService.getProductList();
				session.setAttribute("products",  products);
			}
		}catch(ServiceException e){
			System.out.println("DisplayCatalogController: " + e);
			throw new ServletException(e);
		}		
		
		return view;
	}
}
