package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET Method Called....");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST Method Called....");

		String parameter1 = request.getParameter("param1");
		String parameter2 = request.getParameter("param2");
		System.out.println("servlet received text:" + parameter1 + "= " + parameter2);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		System.out.println("From html :" + name + pass);
		response.sendRedirect("app2.html");
	}
	

}
