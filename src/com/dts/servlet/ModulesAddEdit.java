package com.dts.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.model.Module;
import com.dts.service.ModuleService;

/**
 * Servlet implementation class ModulesAddEdit
 */
public class ModulesAddEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, true);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response, boolean isNew) throws ServletException, IOException {
		if(!isNew && request.getParameter("deleteModuleId")!=null && !"".equals(request.getParameter("deleteModuleId"))){
			deleteModule(request.getParameter("deleteModuleId"), request, response);
		}
		if(isNew || (request.getParameter("editModuleId")!=null && !"".equals(request.getParameter("editModuleId")))){
			editOrAddModule(request.getParameter("editModuleId"), request, response);
		}
	}


	private void editOrAddModule(String parameter, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Module module = null;
		try{
			module = ModuleService.getModuleById(Long.parseLong(parameter));
			request.setAttribute("module", module);
		}catch(Exception e){}
		RequestDispatcher dispatcher = request.getRequestDispatcher("modulesAddEdit.jsp");
		dispatcher.forward(request, response);		
	}

	private void deleteModule(String parameter, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(parameter);
		ModuleService.deleteModule(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("modules");
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, false);
	}

}
