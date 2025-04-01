package com.UTSEM.EOG.dto;

public class AlumnoDTO {
    private Long id;
	String matricula;
	int edad;
	String materno;
	String nombre;
	String paterno;
	String password;
	Boolean accesoCorrecto = false;
	
	
	public Boolean getAccesoCorrecto() {
		return accesoCorrecto;
	}
	public void setAccesoCorrecto(Boolean accesoCorrecto) {
		this.accesoCorrecto = accesoCorrecto;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	///////////
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
}
