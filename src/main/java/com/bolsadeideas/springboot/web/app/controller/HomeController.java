package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Otra forma de respuesta, tema importante, ya vimos como cargar una
 * vista(pasar parametros),pero que pasa si quiero redirigir a otra ruta dentro
 * del proyecto o a otra pagina por ejemplo google omitimos el requestMapping
 * por que esta es la ruta por defecto
 */
@Controller
public class HomeController {
	/*
	 * forward RequestDispacher.forwart() del API Servlet en vez de redirgir dentro
	 * del mismo request http va a ir al metodo handler del controller la ruta del
	 * navegaddor no cambia, se mantiene estatica, es para rutas propias de
	 * controladores
	 */
	@GetMapping("/")
	public String home() {
		return "forward:/app/index";
	}

	/*
	 * redirect cuando se ejecuta redirect se reinicia una peticion y se pierden los
	 * parametros, con estea forma podemos redirigir a rutas externas
	 */
//	@GetMapping("/")
//	public String home() {
//		return "redirect:/app/index";
//	}
}
