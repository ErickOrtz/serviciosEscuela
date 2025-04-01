package com.UTSEM.EOG.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UTSEM.EOG.dto.AlumnoDTO;
import com.UTSEM.EOG.model.Alumno;
import com.UTSEM.EOG.repository.AlumnoRepository;

@Service
public class AlumnoService {

	
	@Autowired
	private AlumnoRepository alumnoRepository;
	
	public List<Alumno> obtenerAlumnos(){
		return alumnoRepository.findAll();
	}
	
	public String guardarAlumno(Alumno alumno){
		
		alumnoRepository.save(alumno);
		
		return "Alumno guardado correctamente.";
	}
	
	public String eliminarAlumno(String matriculaAlumno) {
		Optional<Alumno> elAlumno = alumnoRepository.findByMatricula(matriculaAlumno);
		
		if(elAlumno.isPresent()) {
			alumnoRepository.delete(elAlumno.get());
			return "Alumno eliminado correctamente.";
		}
		return "Alumno no encontrado.";
	}
	
	public Alumno consultarAlumno(String matriucla) {
		Optional<Alumno> elAlumno = alumnoRepository.findByMatricula(matriucla);
		
		if(elAlumno.isPresent()) {
			
			alumnoRepository.findByMatricula(matriucla);
			return elAlumno.get();
			
		}
		return new Alumno();
	}
	
	public String actualizarAlumno(AlumnoDTO alumnodto) {
		Optional<Alumno> elAlumno = alumnoRepository.findByMatricula(alumnodto.getMatricula());
		
		if(elAlumno.isPresent()) {
			
			Alumno alumnoEditar = elAlumno.get();
			
			alumnoEditar.setEdad(alumnodto.getEdad());
			alumnoEditar.setMaterno(alumnodto.getMaterno());
			alumnoEditar.setPaterno(alumnodto.getPaterno());
			alumnoEditar.setMatricula(alumnodto.getMatricula());
			alumnoEditar.setNombre(alumnodto.getNombre());
			
			alumnoRepository.save(alumnoEditar);
			
			return "Alumno editado correctamente.";
		}
		return "Alumno no encontrado";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
