package com.unir.peliculas.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.peliculas.model.pojo.Pelicula;
import com.unir.peliculas.model.request.CreatePeliculaRequest;
import com.unir.peliculas.service.PeliculasService;

@RestController
@RequestMapping("peliculas")
public class PeliculasController {
	@Autowired
	private PeliculasService service;

	@GetMapping("/listar")
	public ResponseEntity<List<Pelicula>> getPeliculas() {
		List<Pelicula> peliculas = service.getPeliculas();

		if (peliculas != null) {
			return ResponseEntity.ok(peliculas);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@GetMapping("/{informacion}")
	public ResponseEntity<List<Pelicula>> getPeliculasBySearch(@PathVariable String informacion) {

		List<Pelicula> peliculas = service.getPeliculasBySearch(informacion);

		if (peliculas != null) {
			return ResponseEntity.ok(peliculas);
		} else {
			return ResponseEntity.ok(Collections.emptyList());
		}
	}

	@PostMapping("/peliculas")
	public ResponseEntity<Pelicula> getProduct(@RequestBody CreatePeliculaRequest request) {
		Pelicula createdPelicula = service.createPelicula(request);
		if (createdPelicula != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdPelicula);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@GetMapping("/pelicula/{peliculaId}")
	public ResponseEntity<Pelicula> getPeliculaPorId(@PathVariable("peliculaId") Long peliculaId) throws Exception {
		Pelicula pelicula = service.getPeliculaById(peliculaId);
		if (pelicula != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/actualiza-ejemplares/{peliculaId}/{numEjemplares}/{operacion}")
	public ResponseEntity<?> actualizarEjemplares(@PathVariable("peliculaId") Long peliculaId,
			@PathVariable("numEjemplares") Integer numEjemplares, @PathVariable("operacion") String operacion)
			throws Exception {

		Pelicula pelicula = service.updateEjemplaresById(peliculaId, numEjemplares, operacion);
		return ResponseEntity.ok(pelicula);
	}
}
