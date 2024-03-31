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
@WebServlet("/verifylogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	   String email=  req.getParameter("email");
	     String password = req.getParameter("password");
	     
	     DAOServiceImpl service=new DAOServiceImpl();
	     service.connectDB();
	     boolean status = service.verifyLogin(email, password);
	     
	     if(status)
	     {
	    	HttpSession session= req.getSession(true);
	    	session.setAttribute("email", email);
	    	
	    	System.out.println("login successful");
	    	
	      RequestDispatcher rd=  req.getRequestDispatcher("WEB-INF/views/add-registration.jsp");
	      rd.forward(req, resp);
	     }
	     else
	     {
	    	 System.out.println("invalid email or password");
	    	 
	    	 req.setAttribute("error","invalid username/password");
	    	 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
	    	 rd.forward(req, resp);
	     }
	
	}

}
