package com.example.recursos;

import org.slf4j.Logger;

/**
 * Clase con métodos para validar campos de los formularios de la aplicación
 * @author RAFAEL VELASQUEZ 30/3/2020
 *
 */
public class Validadores {
	
	
	/**
	 * Revisa que solo tenga letras, nada de números ni caracteres especiales, acepta la ñ los acentos á é í ó ú
	 * @param cadena
	 * @return true si tiene números o cualquier caracter especia como [+,´,¡]
	 */
	public static boolean revisarSoloLetrasDelEspannol(String cadena) {

		boolean bandera = false;
		char[] array = cadena.toCharArray();

		for (char c : array) {
			//Si no es letra rompe el bucle y devuelve falso
			if (!Character.isLetter(c)) {
				bandera = true;
				break;
			}
		}
		return bandera;
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
