package com.example.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import com.example.service.usuario.IUsuarioService;


/**
 * Controlador para el usuario 26/3/20
 * @author Rafael Velásquez
 *
 */
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
	 
	 
	 @PostMapping("/crearUsuario")
	 public String crearUsaurioPost(@Valid Usuario usuario, BindingResult status, RedirectAttributes flash, Model model,SessionStatus sesion) {
		 
		 usuarioValidador.validate(usuario,status);
		 if (status.hasErrors()) {
			 	model.addAttribute("cuidado", "Formulario con errores");
				return "usuario/usuarioCrear";
			}
		 //Guardamos el usuario den la base de datos
		 usuarioService.guardar(usuario);
		 //log en la aplicacón
		 log.info("Se creo un usuario correctamente id: ".concat(usuario.getId().toString()));
		 //enviamos el mensaje a la vista, que el usuario se guardo
		 flash.addFlashAttribute("exito", "Usuario: ' <strong>".concat(usuario.getNombre()).concat("</strong> ' creado Correctamente"));
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
		return "usuario/usuarioEditar";
	}
	
	
	/**
	 * Tomamos el titulo del titulos.properties, para la vista usaurioIndex
	 */
	@Value("${titulo.usuarioIndex}")
	private String tituloUsuario;	
	/**
	 * Tomamos el titulo del titulos.properties, para la vista crearUsaurioIndex
	 */
	@Value("${titulo.usuarioCrear}")
	private String tituloCrearUsuario;	
	
	/**
	 * Titulo de la vista usuario index 
	 * @return
	 */
	@ModelAttribute("usuarioIndex") // Atributo que siempre llevara el model
	public String tituloUsuarioIndex() {
		 //Se toma el título desde titulos.properties
		return tituloUsuario;
	}
	/**
	 * Titulo de la vista usuario Crear usuario 
	 * @return
	 */
	@ModelAttribute("usuarioCrear") // Atributo que siempre llevara el model
	public String crearUsuarioIndex() {
		//Se toma el título desde titulos.properties
		return tituloCrearUsuario;
	}
	
	/**
	 * Tomamos el titulo del titulos.properties, para la vista usaurioEdita
	 */
	@Value("${titulo.usuarioEditar}")
	private String tituloUsuarioEditar;
	
	/**
	 * Titulo de la vista usuario index 
	 * @return
	 */
	@ModelAttribute("usuarioEditar") 
	public String tituloUsuarioEditar() {
		//Se toma el título desde titulos.properties
		return tituloUsuarioEditar;
	}
	

}
