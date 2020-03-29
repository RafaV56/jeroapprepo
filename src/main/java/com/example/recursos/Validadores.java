package com.example.recursos;


/**
 * Clase con métodos para validar campos de los formularios de la aplicación
 * @author RAFAEL VELASQUEZ 30/3/2020
 *
 */
public class Validadores {
	
	public static String revisarSoloLetrasDelEspannol(String cadena) {
		
		char[] array=cadena.toCharArray();
		
		
		
		return null;
	}
	
	/**
	 * Revisa los espacios en blanco al final de un string para borrarlos
	 * @param usu usuario a validar
	 */
	public static String revisarEspaciosEnBlancoAlPrincipioYAlfinal(String cadena) {
		//Revisamos que no termine en espacios en blanco
		boolean bandera=false; //si se encuentra un caracter diferente a espacio ya no se válida más
		String apoyo="";
		int largo=cadena.length()-1;
		//Revisamos los espacios finales
		for (int i =largo; i >= 0; i--) {
			//si todavia no hay bander
			if (!bandera && cadena.charAt(i)==' ') {
				continue;
			}else {
				bandera=true;
				apoyo=cadena.charAt(i)+apoyo;
			}
			
		}
		return apoyo.toString().trim();	
		
	}

}
