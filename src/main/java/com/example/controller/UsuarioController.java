package com.example.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.models.entitys.Usuario;
import com.example.models.validadores.UsuarioValidador;
import com.example.recursos.Validadores;
import com.example.service.usuario.IUsuarioService;


/**
 * Controlador para el usuario 26/3/20
 * @author Rafael Velásquez
 *
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
@Controller
@SessionAttributes("usuario")
public class UsuarioController {
	
	
	/**
	 * Obj para poder hacer entradas en el log
	 */
	private final Logger log=org.slf4j.LoggerFactory.getLogger(getClass());
	
	@Autowired
	private IUsuarioService usuarioService;
	
	/**
	 * Controlador para la el index del usuario
	 * @param model
	 * @return
	 */
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@GetMapping("/usuario")
	public String indexUsuario(Model model) {
		model.addAttribute("usuarios", usuarioService.buscarTodos());
		return "usuario/usuarioIndex";
	}
	 /**
	  * Controlador para la el crear Usuario
	  * @param model
	  * @return
	  */
	 @GetMapping("/crearUsuario")
	 public String crearUsuario(Model model) {
		Usuario usuario=new Usuario();	
		 usuario.setDiaNacimiento(2);
		 usuario.setAnnoNacimiento(1985);
		 usuario.setMesNacimiento(10);
		 usuario.setHoraNacimiento(23);
		 usuario.setMinutoNacimiento(50);
		 usuario.setNombre("PEDRO");
		 usuario.setTalla(160D);
		 usuario.setPeso(160D);
		 model.addAttribute("usuario", usuario);
		 return "usuario/usuarioCrear";
	 }
	 
	 @Autowired
	 UsuarioValidador usuarioValidador;
	 
	 /**
	  * Poder obtener los mensajes de idioma
	  */
	 @Autowired
	 private MessageSource mensajesIdioma;
	 
	 /**
	  * Crea un usaurio válidado
	  * @param usuario
	  * @param status errores del formulario
	  * @param flash enviar comentarios a las vistas
	  * @param model datos
	  * @param sesion session del usuario
	  * @param locale para el idioma y poder cambiar los textos
	  * @return
	  */
	 @PostMapping("/crearUsuario")
	 public String crearUsaurioPost(@Valid Usuario usuario, BindingResult status, RedirectAttributes flash, Model model,SessionStatus sesion,Locale locale) {
		//Validamos primero la fecha de nacimiento
		 try {
			usuario.verFechaNacimiento();
		} catch (RuntimeException e) {
			model.addAttribute("cuidado", e.getMessage());
			return "usuario/usuarioCrear";
		}
		 
		 //Validamos el restos de campos
		 usuarioValidador.validate(usuario,status);
		 if (status.hasErrors()) {
			 	model.addAttribute("cuidado", mensajesIdioma.getMessage("error.fomulario", null, locale));
				return "usuario/usuarioCrear";
			}
		 //si todo va bien Guardamos el usuario den la base de datos
		 usuarioService.guardar(usuario);
		 //log en la aplicacón
		 log.info("Se creo un usuario correctamente id: ".concat(usuario.getId().toString()));
		 //enviamos el mensaje a la vista, que el usuario se guardo
		 flash.addFlashAttribute("exito",mensajesIdioma.getMessage("usuario.creado", null, locale)+ "<strong> ' ".concat(usuario.getNombre()).concat(" '</strong>"));
		 sesion.setComplete();//terminamos la sesion
		 return "redirect:usuario";
	 }
	
	 
	 
	
	 /**
	  * Controlador para editar el usuario
	  * @param model
	  * @return
	  */
	@GetMapping("/editarUsuario")
	public String verUsuario(Model model) {
		model.addAttribute("exito", new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("admin"));
		return "usuario/usuarioEditar";
	}
	
	
	

}
