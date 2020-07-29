package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Otra forma de mandar parámetros mediante las ruta URL al controlador, pero
 * esta vez en la ruta que estamos mapeando en los métodos handle, esta esta
 * forma es propia de las rutas o Paths de Spring
 */
@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	/*
	 * la parte dinámica de la ruta va entre llave en este caso "texto", e
	 * importante que el nombre del parámetro sea igual
	 */
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "el texto de la ruta es: " + texto);

		return "variables/ver";
	}
}
