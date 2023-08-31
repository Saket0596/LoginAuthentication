package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.entities.User;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User us=new User();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
		
		UserDAO dao=new UserDAO(DBConnect.getConnection());
		boolean f=dao.userResgister(us);
		if(true) {
			HttpSession session=request.getSession();
			session.setAttribute("reg-msg", "Registration Succesfully Done....");
			response.sendRedirect("register.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("error-msg", "Something went wrong on server....");
			response.sendRedirect("register.jsp");
		}
		
		
	}

}
