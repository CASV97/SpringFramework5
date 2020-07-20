package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.model.Usuario;

//componente de Spring del tipo controlador
@Controller
@RequestMapping("/app")
public class IndexController {
	@GetMapping({ "/index", "/", "home", "" })
	public String showIndex(Model model) {

		model.addAttribute("titulo", "Hola Spring framework");
		return "index";
	}

	// si no se especifica ningún metodo de peticion por defecto es GET
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		//esta clase debe venir de una base de datos por ejemplo usando HIBERNATE o JPA
		Usuario usuario = new Usuario();
		usuario.setNombre("Ariel");
		usuario.setApellido("Salazar");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
		
		return "perfil";
	}
}
