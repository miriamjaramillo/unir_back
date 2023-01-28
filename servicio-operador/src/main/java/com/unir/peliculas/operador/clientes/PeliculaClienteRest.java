package com.unir.peliculas.operador.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.unir.peliculas.operador.model.pojo.Pelicula;

@FeignClient(name = "servicio-pelicula",url="http://localhost:8090/peliculas")
public interface PeliculaClienteRest {

	@GetMapping("/pelicula/{peliculaId}")
	public Pelicula getPeliculaPorId(@PathVariable("peliculaId") Long peliculaId);
	
	@PutMapping("/actualiza-ejemplares/{peliculaId}/{numEjemplares}/{operacion}")
	public Pelicula actualizarEjemplares(@PathVariable("peliculaId") Long peliculaId,
			@PathVariable("numEjemplares") Integer numEjemplares, @PathVariable("operacion") String operacion);
}
