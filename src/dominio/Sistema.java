package dominio;

public class Sistema {
	private String nombreSistema;
	private Usuario usuarios[];
	
	public Sistema(String nombreSistema,int cantMaximaUsuaros) {
		this.nombreSistema = nombreSistema;
		this.usuarios=new Usuario[cantMaximaUsuaros];
	} 
	
	
	
	public String getNombreSistema() {
		return nombreSistema;
	}



	public void setNombreSistema(String nombreSistema) {
		this.nombreSistema = nombreSistema;
	}



	public int calcularLaCantidadDeUsuariosLogueados() {
		int logueados=0;
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].isLogueado()) {
				logueados++;
			}
		} return logueados;
		
	}
	
	public int calcularLaCantidadDeUsuariosBloqueados() {
		int bloqueados=0;
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].isBloqueado()) {
				bloqueados++;
			}
		} return bloqueados;
	}

	public int calcularEdadPromedio() {
		int cantidad=0;
		int total=0;
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null) {
				total+=usuarios[i].getEdad();
				cantidad++;
			}
		}
		if(cantidad==0) {
			return 0;
		}
	
		return total/cantidad;
	}
	
	public boolean loguearUsuario(String usuario, String contraseña) {
		if(buscarUsuario(usuario)==null || buscarUsuario(usuario).isBloqueado()) {
			return false;
		}
		
		
		if(buscarUsuario(usuario).getContrasenia().equals(contraseña)) {
			buscarUsuario(usuario).setLogueado(true);
			return true;
		} 
		
		buscarUsuario(usuario).intentosFallidos();
		return false;
	}
	
public boolean IngresarUsuario(Usuario nuevoUsuario) {
	for(int i=0;i<usuarios.length;i++) {
		if(usuarios[i]==null && !userRepetido(nuevoUsuario.getUsuario())) {
			usuarios[i]=nuevoUsuario;
			return true;
		}
	} return false;
		
	}

public boolean userRepetido(String user) {
	for(int i=0;i<usuarios.length;i++) {
		if(usuarios[i]!=null && usuarios[i].getUsuario().equals(user)) {
			return true;
		}
	} return false;
}

	
	public Usuario buscarUsuario(String usuario) {
		for(int i=0;i<usuarios.length;i++) {
			if(usuarios[i]!=null && usuarios[i].getUsuario().equals(usuario)) {
				return usuarios[i];
			}
		} return null;
		
	}
	
}
