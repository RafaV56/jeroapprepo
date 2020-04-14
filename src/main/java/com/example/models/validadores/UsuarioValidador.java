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

		// ----- Validamos el nombre de usuario
		// ----------------------------------------------------------------------

		// Validamos que el nombre de usuario no sea nulo
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
			usuario.setNombreDeUsuario("");
		}
		// Quitamos los espacios en blanco
		usuario.setAlias(Validadores.revisarEspaciosEnBlancoAlPrincipioYAlfinal(usuario.getAlias().trim()));
		// Luego revisamos que tenga el tamaño de 3 - 60 caracteres
		if (usuario.getAlias().length() < 3 || usuario.getAlias().length() > 60) {
			// la info esta en el messages.properties que se crea y no hay que configurarlo
			errors.rejectValue("alias", "size.usuario.alias");
		}
		if (Validadores.revisarSoloLetrasDelEspannol(usuario.getAlias())) {
			// Informamos que no se puede tener números ni caracrteres especiales
			errors.rejectValue("alias", "letras.usuario.alias");
		}

		// -----------------------------------------------------------------------------------------------------

		// ----- Validamos la talla y el peso en la propia clase con las anotaciones

		// ----- Validamos la fecha de nacimiento,


	}

}
