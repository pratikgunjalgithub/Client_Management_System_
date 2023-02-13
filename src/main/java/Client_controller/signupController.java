package Client_controller;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Client_bo.client_bio;
import Client_dao.client_dao;
 
 

@WebServlet("/signupController")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pass");
		
		// pw.print(name+" "+email+" "+phone+" "+pwd);
		
		client_bio em = new client_bio();
		
		em.setName(name);
		em.setEmail(email);
		em.setPhone(phone);
		em.setPass(pwd);;
		
		int status = client_dao.signup(em);
		
		if(status >0)
		{
			System.out.println("signup sucessfully");
			pw.print("You are done Signup, Kindly login with username");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
			
		}
		else
		{
			pw.print("Something went wrong");
			response.sendRedirect("signup.html");
			//response.sendRedirect("login.html");
		}
		
		
		
	}

}