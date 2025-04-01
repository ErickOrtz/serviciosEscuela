package com.UTSEM.EOG.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UTSEM.EOG.service.AlumnoService;

@RestController
@RequestMapping("auth")
public class AuthController {
	
	@Autowired
	AlumnoService alumnoService;
	

}
