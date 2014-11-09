package com.dts.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dts.model.User;
import com.dts.service.UserService;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getParameter("username");
		String password = request.getParameter("password");
		
		RequestDispatcher requestDispatcher = null;
		User user = UserService.authenticateUser(user_name, password);
		if(user!=null){
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			requestDispatcher = request.getRequestDispatcher("home.jsp");
		}else{
			requestDispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Incorrect Username or password");
		}
		requestDispatcher.forward(request, response);
	}

}
