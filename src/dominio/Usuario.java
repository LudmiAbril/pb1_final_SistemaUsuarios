package dominio;

public class Usuario {
	private String usuario;
	private String contrasenia;
	private String nombre;
	private String apellido;
	private int edad;
	private boolean logueado;
	private boolean bloqueado;
	private static String [] contraseñasPrevias=new String[5];
	private static int intentos;
	
	public Usuario(String usuario, String nombre, String apellido, int edad) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public static boolean guardarContra(String contra) {
		for(int i=0;i<contraseñasPrevias.length;i++) {
			if(contraseñasPrevias[i]==null) {
				contraseñasPrevias[i]=contra;
				return true;
			}
		} contraseñasPrevias[0]=contra;
		return true;
	}
	
	public static boolean contraRepetida(String contrasenia) {
		for(int i=0;i<contraseñasPrevias.length;i++) {
			if(contraseñasPrevias[i].equals(contrasenia)) {
				return true;
			}
		} return false;
	}

	public boolean laContraseniaEsValida(String contraseña){
		if(contraseña.length()>=8 && tieneNum(contraseña) && tieneMayusc(contraseña) && tieneMayusc(contraseña)
				&& tieneCaracter(contraseña)) {
			this.setContrasenia(contraseña);
			guardarContra(contraseña);
			return true;
		} return false;
	}
	
	public static boolean tieneNum(String contraseña) {
		for(int i=0;i<contraseña.length();i++) {
			if(contraseña.charAt(i)>47 && contraseña.charAt(i)<58) {
				return true;
			}
		} return false;
	}
	
	public static boolean tieneMayusc(String contraseña) {
		for(int i=0;i<contraseña.length();i++) {
			if(contraseña.charAt(i)>64 && contraseña.charAt(i)<91) {
				return true;
			}
		} return false;
	}
	
	public static boolean tieneMinusc(String contraseña) {
		for(int i=0;i<contraseña.length();i++) {
			if(contraseña.charAt(i)>96 && contraseña.charAt(i)<123) {
				return true;
			}
		} return false;
	}
	
	public static boolean tieneCaracter(String contraseña) {
		for(int i=0;i<contraseña.length();i++) {
			if(contraseña.charAt(i)==45 || contraseña.charAt(i)==95) {
				return true;
			}
		} return false;
	}
	
	
	public boolean cambiarContrasenia(String contraseña) {
		if(laContraseniaEsValida(contraseña) && !contraRepetida(contrasenia) ) {
			setContrasenia(contrasenia);
			guardarContra(contraseña);
			return true;
		} return false;
	}
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public void intentosFallidos() {
		intentos++;
		if(intentos==3) {
			setBloqueado(true);
		}
		
	}
	
	
	
	
}
