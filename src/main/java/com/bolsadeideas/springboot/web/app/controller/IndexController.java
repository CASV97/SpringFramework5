package com.bolsadeideas.springboot.web.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.model.Usuario;

//componente de Spring del tipo controlador
@Controller
@RequestMapping("/app")
public class IndexController {
	/*
	 * Con spring boot podemos desacoplar los textos del controlador y llevarlos al
	 * properties o a un fichero, utilizando la anotación @value con esto injectamos
	 * los valores del properties
	 */
	@Value("${indexcontroller.index.titulo}")
	private String tituloIndex;

	@Value("${indexcontroller.perfil.titulo}")
	private String tituloPerfil;

	@Value("${indexcontroller.listar.titulo}")
	private String tituloListar;

	@GetMapping({ "/index", "/", "home", "" })
	public String showIndex(Model model) {

		model.addAttribute("titulo", tituloIndex);
		return "index";
	}

	// si no se especifica ningún metodo de peticion por defecto es GET
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		// esta clase debe venir de una base de datos por ejemplo usando HIBERNATE o JPA
		Usuario usuario = new Usuario();
		usuario.setNombre("Ariel");
		usuario.setApellido("Salazar");
		usuario.setEmail("ariel-w@hotmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", tituloPerfil.concat(usuario.getNombre()));

		return "perfil";
	}

	// if & each de thymeleaf
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", tituloListar);

		return "listar";
	}

	// otra forma de pasar datos a la vista usando la anotacion @ modelAttribute en
	// un metodo separado o trubuto del model y pasamos el nombre con el que
	// queremos guardar en la vista, este metodo ta esta disponible para todos los
	// demas del controlador
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andres", "guiado", "andi@gmail.com"));
		usuarios.add(new Usuario("Pablo", "guiado", "andi@gmail.com"));
		return usuarios;
	}
}
