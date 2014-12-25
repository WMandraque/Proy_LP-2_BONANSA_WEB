package com.bonansa.beans;

public class Persona {
	
	
	public Persona(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	String nombre;
	String Apellido;
	int    edad;

}
