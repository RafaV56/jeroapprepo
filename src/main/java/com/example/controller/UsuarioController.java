package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.service.usuario.IUsuarioService;


/**
 * Controlador para el usuario 26/3/20
 * @author Rafael Velásquez
 *
 */
@Controller
public class UsuarioController {
	
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
		 return "usuario/usuarioCrear";
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
