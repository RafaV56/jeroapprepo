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
		Usuario usuario=(Usuario)target;
		//Validamos que el nombre no sea nulo
		if (usuario.getNombre()==null) {
			errors.rejectValue("nombre", "null.usuario.nombre");
			usuario.setNombre("");
		}
		//Quitamos los espacios en blanco
		usuario.setNombre(Validadores.revisarEspaciosEnBlancoAlPrincipioYAlfinal(usuario.getNombre()));
		//Luego revisamos que tenga el tamaño de 3 - 50 caracteres
		if (usuario.getNombre().length()<3 || usuario.getNombre().length()>50 ) {
			//la info esta en el messages.properties que se crea y no hay que configurarlo
			errors.rejectValue("nombre", "size.usuario.nombre");
		}
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
