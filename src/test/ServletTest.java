package test;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import frd.session.SessionManager;
import frd.session.UserSession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletTest() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession s = request.getSession();
		response.setContentType("text/html");
		PrintWriter w = response.getWriter(); 
		
		w.println("<h1>Servlet : Test</h1>");
		
		String username = request.getParameter("username");
		
//		Usuario que tengo que pasar como dato
		UserSession u = new UserSession(username);
			u.setNombre("Diego");
			u.setApellido("Colussi");
			u.setRol("ADMIN");
			
//		Manejador de sesion. Pasamos como dato la sesion
		SessionManager smgr = new SessionManager(s);
			
//		Creamos una sesion para el usuario definido anteriormente.
		smgr.crearSesion(u);
		smgr.setNewTimeOut(1);

		response.sendRedirect("index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
