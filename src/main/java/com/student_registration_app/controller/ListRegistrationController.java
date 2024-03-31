package com.student_registration_app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.student_registration_app.model.DAOServiceImpl;
@WebServlet("/listRegistration")
public class ListRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListRegistrationController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		HttpSession session=request.getSession(false);
		if(session.getAttribute("email")!=null)
		{
		DAOServiceImpl service=new DAOServiceImpl();
		service.connectDB();
		
		ResultSet result = service.listRegistration();
		request.setAttribute("result", result);
		
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/list-registration.jsp");
		rd.forward(request, response);
		
		}
		
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
