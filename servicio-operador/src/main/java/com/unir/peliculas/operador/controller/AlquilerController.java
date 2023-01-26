package com.unir.peliculas.operador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.unir.peliculas.operador.model.pojo.Alquiler;
import com.unir.peliculas.operador.model.pojo.Pelicula;
import com.unir.peliculas.operador.model.service.AlquilerServiceFeign;

@RestController
@RequestMapping("")
public class AlquilerController {
	
	@Autowired
	@Qualifier("serviceFeign")
	private AlquilerServiceFeign alquilerService;
	
	@GetMapping(value="/pelicula/{peliculaId}", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<?> getPeliculaPorId(@PathVariable("peliculaId") Long peliculaId){
	  Pelicula pelicula = alquilerService.findById(peliculaId);
	  return  ResponseEntity.ok().body(pelicula);
	 } 
	
	@PostMapping("/alquilar")
	public ResponseEntity<?> alquilar(@RequestBody Alquiler alquiler){
		Alquiler objalquiler = alquilerService.agregarAlquiler(alquiler);
		return new ResponseEntity<>(objalquiler, HttpStatus.CREATED);

	}

}
