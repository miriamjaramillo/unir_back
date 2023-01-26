package com.unir.peliculas.operador.clientes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.unir.peliculas.operador.model.pojo.Pelicula;

@FeignClient(name = "servicio-pelicula",url="localhost:8090")
public interface PeliculaClienteRest {

	@GetMapping("/pelicula/{peliculaId}")
	public Pelicula getPeliculaPorId(@PathVariable("peliculaId") Long peliculaId);
}
