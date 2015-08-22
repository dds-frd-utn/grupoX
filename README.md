# grupoX
Grupo de Martin de Gesus, Martin Galeano, Nicolas Rodriguez, Diego Colussi

<h3>Sesiones</h3>
Este codigo permite crear la sesion de un usuario para que este pueda navegar por un sistema.

<h3>Como se usan?:</h3>

Previamente creado un servlet deben instanciarse las siguientes clases:

Hay que crear un Manejador de sesion. Pasamos como dato la sesion del servlet.
    
    HttpSession s = request.getSession();
    SessionManager smgr = new SessionManager(s);

el Request es el recuest del servlet... que tiene como parametro obligatorio cuando se lo declara.

Tengo que crear un usuario mediante la clase UserSession
	
		UserSession u = new UserSession("unUserName");
			u.setNombre("estePoneleUnNombre");
			u.setApellido("zaracho");
			u.setRol("ADMIN");
			
Creamos una sesion para el usuario definido anteriormente.

		smgr.crearSesion(u);

Genial, ahora "magicamente" ya esta creada la sesion en el sistema. (ver otros metodos de la clase SessionManager).

Para borrar la sesion hacemos
    
    smgr.eliminarSesion();

<h3>Ejemplo Completo:</h3>

	import frd.session.SessionManager;
	import frd.session.UserSession;

	public class ServletTest extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			HttpSession s = request.getSession();
			String username = request.getParameter("username");
			
			UserSession u = new UserSession(username);
				u.setNombre("Diego");
				u.setApellido("Colussi");
				u.setRol("ADMIN");
				
			SessionManager smgr = new SessionManager(s);
			smgr.crearSesion(u);
			
		}
	}
