package com.dts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.model.Software;
import com.dts.service.SoftwareService;

/**
 * Servlet implementation class Softwares
 */
public class Softwares extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Software> softwares = SoftwareService.getAllsoftwares();
		request.setAttribute("softwares", softwares);
		RequestDispatcher dispatcher = request.getRequestDispatcher("softwares.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String softwareName = request.getParameter("softwareName");
		String softwareDesc = request.getParameter("softwareDesc");
		SoftwareService.saveOrUpdate(id, softwareName, softwareDesc);
		doGet(request, response);
	}

}
