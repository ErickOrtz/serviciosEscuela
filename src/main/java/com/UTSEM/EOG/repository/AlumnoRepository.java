package com.UTSEM.EOG.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UTSEM.EOG.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	
	Optional<Alumno> findByMatricula(String matricula);
}
