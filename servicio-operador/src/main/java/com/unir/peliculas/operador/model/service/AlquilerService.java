package com.unir.peliculas.operador.model.service;

import java.util.List;

import com.unir.peliculas.operador.model.pojo.Alquiler;
import com.unir.peliculas.operador.model.pojo.Pelicula;

public interface AlquilerService {

	public Pelicula findById(Long peliculaId);
	public Alquiler agregarAlquiler(Alquiler alquiler);
	public List<Alquiler> getRentByUserIdOrderFalse(String userId);
	public List<Alquiler> getRentByUserIdOrderTrue(String userId);
	public void completarOrden(String userId);
	public void eliminarAlquiler(String id);	
}
