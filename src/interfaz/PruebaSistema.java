package interfaz;

import java.util.Scanner;

import dominio.Sistema;
import dominio.Usuario;

public class PruebaSistema {

	public static void main(String[] args) {
		Scanner teclado=new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del sistema:");
		String nombreSistema=teclado.next();
		System.out.println("ingrese la cantidad e usuarios que pueden registrarse:");
		int usuariosmaximos=teclado.nextInt();
		Sistema actual=new Sistema(nombreSistema,usuariosmaximos);
		
		
		int opcion;
		do {
		System.out.println("bienvenido al sistema " + actual.getNombreSistema() + ", seleccione la opcion que desea realizar:"
				+ "\n1 - Regitrar nuevos usuarios en el sistema"
				+ "\n2 - Ver las estadisticas del sistema"
				+ "\n3 - Loguearse"
				+ "\n7 - Salir");
		
		opcion=teclado.nextInt();
		
		switch(opcion) {
		case 1: registrarUsuario(teclado,actual);
			break;
			
		case 2: verEstadisticas(actual);
			break;
			
		case 3: loguearse(teclado,actual);
			break;
			
		case 7: System.out.println("gracias por usar el sistema");
			break;
			
		default: System.out.println("opcion incorrecta");
			break;
		}
		
	}while(opcion!=7);
		

	}
	
	public static void loguearse(Scanner teclado, Sistema actual) {
		System.out.println("ingrese el usuario");
		String user=teclado.next();
		System.out.println("ingrese la contrasenia");
		String contrsena=teclado.next();
		
		if(actual.loguearUsuario(user, contrsena)) {
			System.out.println("logueo exitoso");
		}else {
			System.out.println("no se pudo loguear correctamente");
		}
	}
	
	
	
	
	
	
	public static void verEstadisticas(Sistema actual) {
		System.out.println("** ESTADISTICAS **"
				+ "\n usuarios logueados: " + actual.calcularLaCantidadDeUsuariosLogueados()
				+ "\n usuarios bloqueados: " + actual.calcularLaCantidadDeUsuariosBloqueados()
				+ "\n edad promedio:" + actual.calcularEdadPromedio());
	}
	
	public static void registrarUsuario(Scanner teclado, Sistema actual) {
		System.out.println("ingrese el user");
		String user=teclado.next();
		System.out.println("ingrese el nombre");
		String nombre=teclado.next();
		System.out.println("ingrese el apellido");
		String apellido=teclado.next();
		System.out.println("ingrese la edad");
		int edad=teclado.nextInt();
		Usuario usuario= new Usuario(user,nombre,apellido,edad);
		String contrasenia;
		boolean valido;
		do {
		System.out.println("cree la contrasenia. Debe contener una mayuscula, una minuscula, un numero y un caracter:");
		contrasenia=teclado.next();
		valido=usuario.laContraseniaEsValida(contrasenia);
		}while(!valido);
		
		if(actual.IngresarUsuario(usuario)) {
			System.out.println("se registro el usuario");
		} else {
			System.out.println("no se pudo registrar el usuario, probablemente el  nombre de usuario ya existe");
		}
	}

}
