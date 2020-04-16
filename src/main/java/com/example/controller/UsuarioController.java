package com.example.controller;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.models.entitys.Usuario;
import com.example.models.validadores.UsuarioValidador;
import com.example.service.jugador.IJugadorService;
import com.example.service.usuario.RolServiceImpl;
import com.example.service.usuario.UsuarioServiceImpl;

/**
 * Controlador para el usuario 26/3/20
 * 
 * @author Rafael Velásquez
 *
 */

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

	/**
	 * Obj para poder hacer entradas en el log
	 */
	private final Logger log = org.slf4j.LoggerFactory.getLogger(getClass());

	@Autowired
	private IJugadorService usuarioService;

	/**
	 * Controlador para la el index del usuario
	 * 
	 * @param model
	 * @return
	 */
	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/usuario")
	public String indexUsuario(Model model,HttpServletRequest request) {
		model.addAttribute("usuarios", usuarioService.buscarTodos());
		return "usuario/usuarioIndex";
	}

	/**
	 * Controlador para la el crear Usuario
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/crearUsuario")
	public String crearUsuario(Model model,Principal principal,RedirectAttributes flash,Locale locale,HttpServletRequest request) {
		if (principal!=null) {
			if(!new SecurityContextHolderAwareRequestWrapper(request,"ROLE_").isUserInRole("ADMIN")) {
				flash.addFlashAttribute("cuidado",  mensajesIdioma.getMessage("error.crearusuario", null, locale));
				return "redirect:/";
			}	
		}
		Usuario usuario = new Usuario();
		usuario.setActivo(true);
		usuario.setAlias("alias");
		usuario.setNombreDeUsuario("nombre");
		usuario.setApellidos("apellido");
		usuario.setPassword("password");
		usuario.setRoles(null);
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

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	private RolServiceImpl rolServiceImpl;

	@PostMapping("/crearUsuario")
	public String crearUsaurioPost(@Valid Usuario usuario, BindingResult status, RedirectAttributes flash, Model model,
			SessionStatus sesion, Locale locale) {
		
		 //Validamos el restos de campos
		 usuarioValidador.validate(usuario,status);
		 if (status.hasErrors()) {
			 	model.addAttribute("cuidado", mensajesIdioma.getMessage("error.fomulario", null, locale));
				return "usuario/usuarioCrear";			}
		
		usuarioServiceImpl.guardar(usuario);
		flash.addFlashAttribute("exito",mensajesIdioma.getMessage("usuario.creado", null, locale)+ "<strong> ' ".concat(usuario.getNombreDeUsuario()).concat(" '</strong>"));
		return "redirect:/";
	}

	// /**
//	  * Crea un Jugador válidado
//	  * @param usuario
//	  * @param status errores del formulario
//	  * @param flash enviar comentarios a las vistas
//	  * @param model datos
//	  * @param sesion session del usuario
//	  * @param locale para el idioma y poder cambiar los textos
//	  * @return
//	  */
//	 @PostMapping("/crearUsuario")
//	 public String crearUsaurioPost(@Valid Jugador usuario, BindingResult status, RedirectAttributes flash, Model model,SessionStatus sesion,Locale locale) {
//		//Validamos primero la fecha de nacimiento
//		 try {
//			usuario.verFechaNacimiento();
//		} catch (RuntimeException e) {
//			model.addAttribute("cuidado", e.getMessage());
//			return "usuario/usuarioCrear";
//		}
//		 
//		 //Validamos el restos de campos
//		 usuarioValidador.validate(usuario,status);
//		 if (status.hasErrors()) {
//			 	model.addAttribute("cuidado", mensajesIdioma.getMessage("error.fomulario", null, locale));
//				return "usuario/usuarioCrear";
//			}
//		 //si todo va bien Guardamos el usuario den la base de datos
//		 usuarioService.guardar(usuario);
//		 //log en la aplicacón
//		 log.info("Se creo un usuario correctamente id: ".concat(usuario.getId().toString()));
//		 //enviamos el mensaje a la vista, que el usuario se guardo
//		 flash.addFlashAttribute("exito",mensajesIdioma.getMessage("usuario.creado", null, locale)+ "<strong> ' ".concat(usuario.getNombre()).concat(" '</strong>"));
//		 sesion.setComplete();//terminamos la sesion
//		 return "redirect:usuario";
//	 }

	/**
	 * Controlador para editar el usuario
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/editarUsuario")
	public String verUsuario(Model model) {
		// encriptar una contra
		// model.addAttribute("exito", new
		// org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode("usuario"));

		// Desenvcriptar una contraseña
		// model.addAttribute("exito", new
		// org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().matches("admin",
		// "$2a$10$JS7iOrTDGDBOZzdZ2/cHrOgQQkQRgO8AOwNQz2NpEa6FrOW3zUsDq"));

		return "usuario/usuarioEditar";
	}

}
