package com.dts.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.model.Module;
import com.dts.service.ModuleService;

/**
 * Servlet implementation class Modules
 */
public class Modules extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Module> modules = ModuleService.getAllModules();
		request.setAttribute("modules", modules);
		RequestDispatcher dispatcher = request.getRequestDispatcher("modules.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String moduleName = request.getParameter("moduleName");
		String moduleDesc = request.getParameter("moduleDesc");
		String softwareId = request.getParameter("softwareId");
		ModuleService.saveOrUpdate(id, moduleName, moduleDesc, softwareId);
		doGet(request, response);
	}

}
