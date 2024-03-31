package com.student_registration_app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.student_registration_app.model.DAOServiceImpl;
@WebServlet("/updateRegistration")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
	
	request.setAttribute("email", email);
	request.setAttribute("mobile", mobile);
	
	RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/update-registration.jsp");
	rd.forward(request, response);
		
	      
	       
	       
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   String email=  request.getParameter("email");
	   String mobile=  request.getParameter("mobile");
	   
	   DAOServiceImpl service=new DAOServiceImpl();
	   service.connectDB();
	   service.updateRegistration(mobile, email);
	
	}

}
