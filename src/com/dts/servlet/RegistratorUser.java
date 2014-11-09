package com.dts.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.service.UserService;

/**
 * Servlet implementation class RegistratorUser
 */
public class RegistratorUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fist_name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String user_name = request.getParameter("username");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");
		String qualification = request.getParameter("qualification");
		String address = request.getParameter("address");
		String email = request.getParameter("e-mail");
		String contactNumber = request.getParameter("contactNumber");
		
		RequestDispatcher requestDispatcher = null;
		boolean isUserAlreadyExists = UserService.isUserAlreadyExists(user_name);
		if(!isUserAlreadyExists){
			UserService.registerUser(fist_name, last_name, user_name, password, 
					designation, qualification, address, email, contactNumber);
			requestDispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "User successfully Added, Please login now.");
		}else{
			requestDispatcher = request.getRequestDispatcher("registration.jsp");
			request.setAttribute("msg", "User Already Exists, Please use another username");
		}
		requestDispatcher.forward(request, response);
	}

}
