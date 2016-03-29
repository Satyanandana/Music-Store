package cs636.music.presentation.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import cs636.music.service.*;
import cs636.music.domain.*;

public class DisplayCartController extends HttpServlet implements Controller
{
	private UserServiceAPI userService;
	
	public DisplayCartController(UserServiceAPI userService){
		this.userService = userService;
	}
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		System.out.println("In DisplayCartController");
		HttpSession session = request.getSession();

		String quantityString = request.getParameter("quantity");
		String productCode = request.getParameter("productCode");
		String removeButtonValue = request.getParameter("removeButton");
		CartBean cart = (CartBean) session.getAttribute("cart");
		String url="";
		int quantity = 1;		
		
		try{					
			if(cart == null)
			{
				cart = new CartBean();
				session.setAttribute("cart", cart);
			}			
			
			if(quantityString!=null){
			quantity = Integer.parseInt(quantityString);
			}
			if(quantity < 0)
				quantity = 1;
			
			if(removeButtonValue != null)
			{
				quantity = 0;
			}
			Product product=null;
			if(productCode!=null){
			
			product = userService.getProduct(productCode);
			session.setAttribute("product", product);
			}
			
			if(product != null)
			{
				LineItem lineItem = new LineItem();
				lineItem.setProduct(product);
				lineItem.setQuantity(quantity);
				if(quantity > 0)
					cart.addItem(lineItem);
				else
					cart.removeItem(product);
			}
			session.setAttribute("cart", cart);			
			
			
				
		}catch(ServiceException e){
			System.out.println("DisplayCatalogController: " + e);
			throw new ServletException(e);
		}catch(NumberFormatException nfe){
			quantity = 1;
		}
		
		
		url = "/WEB-INF/jsp/displayCart.jsp";
		
		return url;

			
	}
}