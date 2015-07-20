package frd.session;

// Clase que va a contener la informacion que deseamos guardar en sesion.
public class UserSession {
	
	/*Atributos*/
		public String username;
		public String nombre;
		public String apellido;
		public String rol;
	
	// Inicializar usuario
	public UserSession() {
		nombre = null;
		apellido = null;
		username = null;
		rol = null;
	}
	
	// Inicializar usuario con username
	public UserSession(String u){
		username = u;
	}

//  Setear Username
	public void setUsername(String p){
		this.username = p;
	}
	
//	Setear Username
	public void setNombre(String p){
		this.nombre = p;
	}
	
//	Setear Apellido
	public void setApellido(String p){
		this.apellido = p;
	}
	
//	Setear Rol
	public void setRol(String p){
		this.rol = p;
	}
	
//	Retornar username
	public String getUsername(){
		return username;
	}
	
//	Retornar Nombre
	public String getNombre(){
		return nombre;
	}
	
//	Retornar Apellido
	public String getApellido(){
		return apellido;
	}
	
//	Retornar Rol
	public String getRol(){
		return rol;
	}
	
}
