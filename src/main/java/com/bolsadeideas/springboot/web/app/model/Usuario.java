package com.bolsadeideas.springboot.web.app.model;

//la idea de un POJO es que sea totalmente desacoplada de cualquier framework o API
public class Usuario {
	public String nombre;
	public String apellido;
	public String email;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String apellido, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
