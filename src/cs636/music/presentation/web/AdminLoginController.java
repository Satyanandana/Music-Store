package cs636.music.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs636.music.domain.User;
import cs636.music.service.AdminServiceAPI;
import cs636.music.service.ServiceException;
import cs636.music.service.UserServiceAPI;

public class AdminLoginController extends HttpServlet implements Controller {
private String view;
private AdminServiceAPI adminService;
	public AdminLoginController(AdminServiceAPI adminService,String view) {
		// TODO Auto-generated constructor stub
		this.view=view;
		this.adminService=adminService;
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		// TODO Auto-generated method stub
		
		
		String url = "";
		String error=null;
		try {
			HttpSession session = request.getSession();
			String requestURL = request.getServletPath();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String preUrl = request.getParameter("preUrl");
			String proCode=request.getParameter("proCode");
			String trackNum=request.getParameter("trackNum");
			if (preUrl == null) {
				request.setAttribute("preUrl", requestURL);
			} else {
				request.setAttribute("preUrl", preUrl);
			}
			
            Boolean admin=(session.getAttribute("admin")!=null);
			//// if list of products doesn't exist, initialize it,
			// and store it for the remainder of the session
			if(username!=null&password!=null){
				 admin = adminService.checkLogin(username, password);
				 if(admin==null){
					 error="Invalid Credentials";
				 }
			}
			if (admin==true) {
				session.setAttribute("admin", admin);
				url = "/WEB-INF/admin/adminWelcome.jsp";
			} else {
				url = view;
				
				
			}
			request.setAttribute("error",error);

		} catch (ServiceException e) {
			System.out.println("UserLoginController: " + e);
			throw new ServletException(e);
		}

		return url;
	}
}
