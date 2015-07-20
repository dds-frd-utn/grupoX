package test;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frd.session.SessionManager;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Logout() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter w = response.getWriter(); 
		HttpSession s = request.getSession();
		w.println("<h1>Servlet : Logout</h1>");
				
		SessionManager smgr = new SessionManager(s);
		smgr.eliminarSesion();
		
		w.println("Sesion Eliminada<br>");
		w.println("<a href='/session'>Volver a Login</a><br>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
