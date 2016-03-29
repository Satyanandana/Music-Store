package cs636.music.presentation.web;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import cs636.music.service.*;
import cs636.music.domain.*;

public class SoundPageController extends HttpServlet implements Controller
{
	private UserServiceAPI userService;
	private String view;
	
	public SoundPageController(UserServiceAPI userService, String view)
	{
		this.userService = userService;
		this.view = view;
	}
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
		HttpSession session = request.getSession();
		
		try{
			String productCode = request.getParameter("productCode");
			
			Product product = userService.getProduct(productCode);
			session.setAttribute("product", product);

			UserBean user = (UserBean) session.getAttribute("user");		
			if(user == null){
				view += "/jsp/register.jsp";
				session.setAttribute("nextPageURL", view + "/sound/" + productCode + "/sound.jsp");
			}
			else
				view += "/sound/" + productCode + "/sound.jsp";		
		}catch(ServiceException e){
			System.out.println("SoundPageController: " + e);
			throw new ServletException(e);
		}
		
		return view;
	}
}