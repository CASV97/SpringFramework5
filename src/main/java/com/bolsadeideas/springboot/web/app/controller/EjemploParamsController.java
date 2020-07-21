package com.bolsadeideas.springboot.web.app.controller;

import javax.servlet.http.HttpServletRequest;

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

	/*
	 * vamos a ver como enviar más de un parámetro en la url, podemos enviar
	 * parámetros de cualquier tipo básico de java, pero lo mas típico es mandar un
	 * String, Integer o long
	 */
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir parámetros del request HTTP GET - URL");
		model.addAttribute("resultado", "el saludo enviado es: '" + saludo + "' y el número es: '" + numero + "'");
		return "/params/ver";
	}

	/**
	 * otra forma de recibir parámetros en el controlador, pero esta vez en vez de
	 * utilizar el <code> @RequestParam </code>, podemos pasar el objeto
	 * <code>HttpServletRequest</code> directamente
	 */
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		// conviene cada vez que se usa un Parse.. conviene usarlo dentro de un bloque
		// try...cath para problemas de conversiones
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));

		} catch (NumberFormatException e) {
			numero = 0;
		}
		model.addAttribute("titulo", "Recibir parámetros del request HTTP GET - URL");
		model.addAttribute("resultado", "el saludo enviado es: '" + saludo + "' y el número es: '" + numero + "'");
		return "/params/ver";
	}

}
