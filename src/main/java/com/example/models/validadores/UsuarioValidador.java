package com.example.models.validadores;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.models.entitys.Usuario;
import com.example.recursos.Validadores;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}
	 
	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		if (usuario==null) {
			throw new RuntimeException("Usuario null"); //revisar y cambiar con idiomas
		}

		// Validamos que el nombre de usuario no sea nulo------------------------------------
		if (usuario.getNombreDeUsuario() == null) {
			errors.rejectValue("nombreDeUsuario", "null.usuario.nombre");
			usuario.setNombreDeUsuario("");
		}
		// Quitamos los espacios en blanco
		usuario.setNombreDeUsuario(Validadores.revisarEspaciosEnBlancoAlPrincipioYAlfinal(usuario.getNombreDeUsuario().trim()));
		// Luego revisamos que tenga el tamaño de 3 - 60 caracteres
		if (usuario.getNombreDeUsuario().length() < 3 || usuario.getNombreDeUsuario().length() > 60) {
			// la info esta en el messages.properties que se crea y no hay que configurarlo
			errors.rejectValue("nombreDeUsuario", "size.usuario.nombre");
		}
		if (Validadores.revisarSoloLetrasDelEspannol(usuario.getNombreDeUsuario())) {
			// Informamos que no se puede tener números ni caracrteres especiales
			errors.rejectValue("nombreDeUsuario", "letras.usuario.nombre");
		}
		
		// ----- Validamos el alias
		// ----------------------------------------------------------------------
		
		// Validamos que el nombre de usuario no sea nulo
		if (usuario.getAlias() == null) {
			errors.rejectValue("alias", "null.usuario.alias");
			usuario.setAlias("");
		}
		// Quitamos los espacios en blanco
		usuario.setAlias(Validadores.revisarEspaciosEnBlancoAlPrincipioYAlfinal(usuario.getAlias().trim()));
		// Luego revisamos que tenga el tamaño de 4 - 60 caracteres
		if (usuario.getAlias().length() < 4 || usuario.getAlias().length() > 60) {
			// la info esta en el messages.properties que se crea y no hay que configurarlo
			errors.rejectValue("alias", "size.usuario.alias");
		}
		if (Validadores.revisarSoloLetrasDelEspannol(usuario.getAlias())) {
			// Informamos que no se puede tener números ni caracrteres especiales
			errors.rejectValue("alias", "letras.usuario.alias");
		}

		// -----------------------------------------------------------------------------------------------------
	
		// ----- Validamos el apellido
		// ----------------------------------------------------------------------
		
		// Validamos que el apellido de usuario no sea nulo
		if (usuario.getApellidos() == null) {
			errors.rejectValue("apellidos", "null.usuario.apellidos");
			usuario.setApellidos("");
		}
		// Quitamos los espacios en blanco
		usuario.setApellidos(Validadores.revisarEspaciosEnBlancoAlPrincipioYAlfinal(usuario.getApellidos().trim()));
		// Luego revisamos que tenga el tamaño de 3 - 60 caracteres
		if (usuario.getApellidos().length() < 4 || usuario.getApellidos().length() > 60) {
			// la info esta en el messages.properties que se crea y no hay que configurarlo
			errors.rejectValue("apellidos", "size.usuario.apellidos");
		}
		if (Validadores.revisarSoloLetrasDelEspannol(usuario.getApellidos())) {
			// Informamos que no se puede tener números ni caracrteres especiales
			errors.rejectValue("apellidos", "letras.usuario.apellidos");
		}
		
		// -----------------------------------------------------------------------------------------------------
		
		
		// ----- Validamos la contraseña
		// ----------------------------------------------------------------------
		
		// Validamos que la contraseña de usuario no sea nulo
		if (usuario.getPassword() == null) {
			errors.rejectValue("password", "null.usuario.password");
			usuario.setPassword("");
		}
		// Quitamos los espacios en blanco
		usuario.setPassword(Validadores.revisarEspaciosEnBlancoAlPrincipioYAlfinal(usuario.getPassword().trim()));
		// Luego revisamos que tenga el tamaño de 6 - 60 caracteres
		if (usuario.getPassword().length() < 7 || usuario.getPassword().length() > 60) {
			errors.rejectValue("password", "size.usuario.password");
		}
		if (Validadores.revisarSoloLetrasDelEspannol(usuario.getPassword())) {
			// Informamos que no se puede tener números ni caracrteres especiales
			errors.rejectValue("password", "letras.usuario.password");
		}
		
		// -----------------------------------------------------------------------------------------------------


	}

}
