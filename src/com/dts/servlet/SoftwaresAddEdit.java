package com.dts.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.model.Software;
import com.dts.service.SoftwareService;

/**
 * Servlet implementation class SoftwaresAddEdit
 */
public class SoftwaresAddEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, false);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response, boolean isNew) throws ServletException, IOException {
		if(!isNew && request.getParameter("deleteSoftwareId")!=null && !"".equals(request.getParameter("deleteSoftwareId"))){
			deleteSoftware(request.getParameter("deleteSoftwareId"), request, response);
		}
		if(isNew || (request.getParameter("editSoftwareId")!=null && !"".equals(request.getParameter("editSoftwareId")))){
			editOrAddSoftware(request.getParameter("editSoftwareId"), request, response);
		}
	}

	private void editOrAddSoftware(String parameter, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Software software = null;
		try{
			software = SoftwareService.getSoftwareById(Long.parseLong(parameter));
			request.setAttribute("software", software);
		}catch(Exception e){}
		RequestDispatcher dispatcher = request.getRequestDispatcher("softwaresAddEdit.jsp");
		dispatcher.forward(request, response);		
	}

	private void deleteSoftware(String parameter, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(parameter);
		SoftwareService.deleteSoftware(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("softwares");
		dispatcher.forward(request, response);
	}

}
