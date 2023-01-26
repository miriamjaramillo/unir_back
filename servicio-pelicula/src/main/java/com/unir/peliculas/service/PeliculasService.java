package com.unir.peliculas.service;

import java.util.List;

import com.unir.peliculas.model.pojo.Pelicula;
import com.unir.peliculas.model.request.CreatePeliculaRequest;

public interface PeliculasService {
	List<Pelicula> getPeliculas();
	List<Pelicula> getPeliculasBySearch(String informacion);
	Pelicula createPelicula(CreatePeliculaRequest request);
	Pelicula getPeliculaById(Long peliculaId);
}
