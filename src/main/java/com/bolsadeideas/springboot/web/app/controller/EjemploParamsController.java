package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*Como enviar parámetros mediante URL a nuestros controladores*/
@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	/*
	 * Aprender como crear nuestras rutas URL, nuestros links con paraámetros con
	 * thymeleaf
	 */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros del request HTTP GET - URL");
		return "params/index";
	}

	/*
	 * esta vez vamos a dejar la vista dentro de un directorio en templates la idea
	 * es pasar parámetros mediante la URL(la ruta) lo podemos capturar con la
	 * anotacion @RequestParam(value), el nombre se podrá colocar desde la misma
	 * anotacion con las propiedades value o name o sino ya hace referencia el
	 * mismmo nombre del parámetro de metodo, parametros GET
	 */

	@GetMapping("/string")
	public String param(@RequestParam(required = false, defaultValue = "algún valor") String texto, Model model) {
		model.addAttribute("titulo", "Recibir parámetros del request HTTP GET - URL");
		model.addAttribute("resultado", "el texto enviado es: " + texto);
		return "/params/ver";
	}

}
