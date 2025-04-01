package com.UTSEM.EOG.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UTSEM.EOG.dto.AlumnoDTO;
import com.UTSEM.EOG.model.Alumno;
import com.UTSEM.EOG.service.AlumnoService;


@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;

	@GetMapping("/listar")
	public List<Alumno> postMethodLitar() {

		return alumnoService.obtenerAlumnos();
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<String> postMethodAgregar(@RequestBody Alumno alumno) {
	    alumnoService.guardarAlumno(alumno);
	    return ResponseEntity.ok().body("Alumno guardado correctamente.");
	}
	
	@PostMapping("/eliminar")
	public String eliminarAlumno(@RequestBody String matricula) {
	    matricula = matricula.replace("\"", ""); // Elimina comillas extra
	    System.out.println(matricula);
	    return alumnoService.eliminarAlumno(matricula);
	}
	
	@PostMapping("/consultar")
	public Alumno consultarAlumno(@RequestBody String matricula) {
		matricula = matricula.replace("\"", ""); // Elimina comillas extra
		return alumnoService.consultarAlumno(matricula);
	}
	
	@PostMapping("/actualizar")
	public String actualizarAlumno(@RequestBody AlumnoDTO alumnodto) {
		//TODO: process POST request
		
		return alumnoService.actualizarAlumno(alumnodto);
	}
	
	
	

}
