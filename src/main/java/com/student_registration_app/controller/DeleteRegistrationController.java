package com.student_registration_app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.student_registration_app.model.DAOServiceImpl;

@WebServlet("/deleteRegistration")
public class DeleteRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String email=request.getParameter("email");
	
	DAOServiceImpl service= new DAOServiceImpl();
	service.connectDB();
	service.deleteRegistration(email);
	
	ResultSet result = service.listRegistration();
	request.setAttribute("result", result);
	
    RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/list-registration.jsp");
	rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
