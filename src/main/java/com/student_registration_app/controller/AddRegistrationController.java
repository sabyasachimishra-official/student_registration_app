package com.student_registration_app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.student_registration_app.model.DAOServiceImpl;
@WebServlet("/addreg")
public class AddRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/add-registration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session=request.getSession(false);
	if(session.getAttribute("email")!=null)
	{
	String name = request.getParameter("name");
	String course= request.getParameter("course");
	String email= request.getParameter("email");
	String mobile= request.getParameter("mobile");
	
	DAOServiceImpl service=new DAOServiceImpl();
    service.connectDB();
    service.addRegistration(name, course, email, mobile);
	
	RequestDispatcher rd=request.getRequestDispatcher("WEB-INF/views/add-registration.jsp");
	rd.forward(request, response);
	}
	else
	{
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		System.out.println("else");
	}

}
}