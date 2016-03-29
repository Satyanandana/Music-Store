package cs636.music.presentation.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs636.music.domain.Download;
import cs636.music.service.AdminServiceAPI;
import cs636.music.service.ServiceException;

public class AllDownloadsController extends HttpServlet implements Controller {
	private String view;
	private AdminServiceAPI adminService;
	public AllDownloadsController(AdminServiceAPI adminService,String view) {
		this.view=view;
		this.adminService=adminService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		HttpSession session=request.getSession();
		Set<Download> downloads=null;
		
		try {
			downloads=adminService.getListofDownloads();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("downloads",downloads);
		// TODO Auto-generated method stub
		return view;
	}

}
