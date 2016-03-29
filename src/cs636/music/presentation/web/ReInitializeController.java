package cs636.music.presentation.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs636.music.service.AdminServiceAPI;
import cs636.music.service.ServiceException;

public class ReInitializeController extends HttpServlet implements Controller {

	private String view;
	private AdminServiceAPI adminService;
		public ReInitializeController(AdminServiceAPI adminService,String view) {
			// TODO Auto-generated constructor stub
			this.view=view;
			this.adminService=adminService;
		}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			adminService.initializeDB();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return view;
	}

}
