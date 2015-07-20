package frd.session;

import javax.servlet.http.HttpSession;

//Session Manager se encarga de la administracion de la sesion del usuario en el sistema.
public class SessionManager {
	
//	Atributos.
		public HttpSession session;
		public String sesId;
//	Fin Atributos.
	
//	Crea un manejador de sesion pasando como parametro la HTTP Sesion del Servlet.
	public SessionManager(HttpSession s){
		session = s;
		sesId = "USER_S1";
		this.setDefaultTimeOut();
	}
	
//	Setea un nuevo Timeout de la sesion.
	public void setNewTimeOut(Integer i){
		session.setMaxInactiveInterval(i);
	}
	
//	Vuelve al timeout por defecto (900seg = 15 Min).
	public void setDefaultTimeOut(){	
		session.setMaxInactiveInterval(900);	
	}
	
//	Especifica que no va a haber timeOut en la sesion.
	public void setNoTimeOut(){	
		session.setMaxInactiveInterval(-1);	
	}
	
// 	Crea una sesion en el sistema.
//	Necesitamos pasar como parametro un objeto UserSession. (No hace falta que tenga todos sus atributos definidos)
	public void crearSesion(UserSession usr){	
		
//		Se crea la variable de sesion. Por default, su id sera USER_S1.
		this.session.setAttribute(sesId, usr);
		
	}
	
//	Devuelve el usuario asociado a la sesion creada. Si la sesion no tiene nada, retornara null.
	public UserSession getCurentUsr(){
		return (UserSession) session.getAttribute(sesId);		
	}
	
//	Realiza lo mismo que el caso anterior, solo que lo devuelve como clase Object (Metodo privado).
	private Object getSessionAttribute(){
		return this.session.getAttribute(sesId);
	}
	
//	Elimina la sesion previamente creada.
	public void eliminarSesion(){
		
		if( getSessionAttribute() != null )
			this.session.setAttribute(sesId, null);
		
	}
	
//	Returna true si el sistema detecta una sesion activa.
	public boolean isActive(){
		
		if( getSessionAttribute() == null )
			return false;
		else
			return true;
		
	}
	
}
